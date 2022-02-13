package es.cristianlm.route

import io.ktor.http.content.*
import io.ktor.routing.*
import javax.inject.Inject

class AssetRoutes @Inject constructor(
) : AppRoute {
    override fun Route.configure() {
        static("assets") {
            resources("assets")
        }
    }
}
