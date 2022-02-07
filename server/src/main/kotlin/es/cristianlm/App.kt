package es.cristianlm

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

class App @Inject constructor(
) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private val started: AtomicBoolean = AtomicBoolean()
    private var ktorEngine: ApplicationEngine? = null

    fun start(wait: Boolean = true) {
        if (started.compareAndSet(false, true)) {

            ktorEngine = embeddedServer(Netty, port = 7200, host = "0.0.0.0") {

                routing {
                    get("/") {
                        call.respondText("Hola")
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
