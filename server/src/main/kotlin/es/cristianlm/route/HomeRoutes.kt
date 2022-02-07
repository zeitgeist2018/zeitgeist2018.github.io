package es.cristianlm.route

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.thymeleaf.*
import javax.inject.Inject

class HomeRoutes @Inject constructor(

) : AppRoute {
    override fun Route.configure() {
        get("/") {
            call.respond(ThymeleafContent("main", mapOf()))
        }
    }
}
