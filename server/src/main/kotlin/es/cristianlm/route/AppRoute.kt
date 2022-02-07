package es.cristianlm.route

import io.ktor.routing.*

interface AppRoute {
    fun apply(route: Route) = route.configure()

    fun Route.configure()
}
