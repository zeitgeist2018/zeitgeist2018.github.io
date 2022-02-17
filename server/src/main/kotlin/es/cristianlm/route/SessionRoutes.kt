package es.cristianlm.route

import es.cristianlm.app.feature.setLang
import es.cristianlm.model.Language
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import javax.inject.Inject

class SessionRoutes @Inject constructor(
) : AppRoute {
    override fun Route.configure() {
        post("/session") {
            val lang = call.request.queryParameters["lang"]?.let {
                if (Language.isValid(it)) Language[it] else Language.default
            } ?: Language.default

            log().debug("Language changed to ${lang.displayName}")
            call.setLang(lang)
            call.respond(HttpStatusCode.OK)
        }
    }
}
