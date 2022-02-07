package es.cristianlm.route

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.thymeleaf.*

interface AppRoute {
    fun apply(route: Route) = route.configure()

    fun Route.configure()

    suspend fun ApplicationCall.template(name: String, params: Map<String, Any> = mapOf()) {
        val model = mutableMapOf<String, Any>(
            "content" to "/pages/$name"
        )
        model.putAll(params)
        respond(ThymeleafContent("main", model))
    }
}
