package es.cristianlm

import es.cristianlm.domain.service.TranslationService
import es.cristianlm.model.Language
import es.cristianlm.route.AppRoute
import es.cristianlm.route.template
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.thymeleaf.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

class App @Inject constructor(
    private val routes: List<@JvmSuppressWildcards AppRoute>,
    private val translationService: TranslationService
) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private val started: AtomicBoolean = AtomicBoolean()
    private var ktorEngine: ApplicationEngine? = null

    fun start(wait: Boolean = true) {
        if (started.compareAndSet(false, true)) {

            ktorEngine = embeddedServer(Netty, port = 7200, host = "0.0.0.0") {
                install(Thymeleaf) {
                    setTemplateResolver(ClassLoaderTemplateResolver().apply {
                        prefix = "thymeleaf/"
                        suffix = ".html"
                        characterEncoding = "utf-8"
                    })
                }

                install(StatusPages) {
                    exception<Throwable> { cause ->
                        val messages =
                            translationService.getTranslationsAsMap("navbar", Language.SPANISH)
                                .plus(translationService.getTranslationsAsMap("status", Language.SPANISH))
                        call.template(
                            "status/500", mapOf(
                                "messages" to messages
                            )
                        )
                        log.error("Unexpected error", cause)
                    }
                }

                routing {
                    route("/") {
                        routes.forEach { it.apply(this) }
                    }
                }
            }.start(wait = wait)
        }
    }

    fun stop() {
        if (started.compareAndSet(true, false)) {
            ktorEngine?.stop(1000, 5000)
        }
    }

}
