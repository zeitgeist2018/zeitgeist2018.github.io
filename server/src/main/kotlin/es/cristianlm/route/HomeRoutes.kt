package es.cristianlm.route

import es.cristianlm.app.feature.getLang
import es.cristianlm.domain.service.TranslationService
import io.ktor.application.*
import io.ktor.routing.*
import javax.inject.Inject

class HomeRoutes @Inject constructor(
    private val translationService: TranslationService
) : AppRoute {
    override fun Route.configure() {
        get("/") {
            val messages = translationService
//                .getTranslationsAsMap(setOf("navbar", "page.home"), call.getLang())
                .getTranslationsAsMap("navbar", call.getLang())

            call.template(
                "home", mapOf(
                    "messages" to messages
                )
            )
        }
    }
}
