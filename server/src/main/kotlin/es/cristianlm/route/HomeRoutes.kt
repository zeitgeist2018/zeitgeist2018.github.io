package es.cristianlm.route

import es.cristianlm.domain.service.TranslationService
import es.cristianlm.model.Language
import io.ktor.application.*
import io.ktor.routing.*
import javax.inject.Inject

class HomeRoutes @Inject constructor(
    private val translationService: TranslationService
) : AppRoute {
    override fun Route.configure() {
        get("/") {
            val messages = translationService
                .getTranslations("navbar", Language.SPANISH)
                .associate { it.key to it.values.values.first() }

            call.template(
                "home", mapOf(
                    "messages" to messages
                )
            )
        }
    }
}
