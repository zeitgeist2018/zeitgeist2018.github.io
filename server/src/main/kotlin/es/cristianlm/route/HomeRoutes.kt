package es.cristianlm.route

import es.cristianlm.domain.service.TranslationService
import es.cristianlm.model.Language
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.thymeleaf.*
import javax.inject.Inject

class HomeRoutes @Inject constructor(
    private val translationService: TranslationService
) : AppRoute {
    override fun Route.configure() {
        get("/") {
            call.template("home")
        }
    }
}
