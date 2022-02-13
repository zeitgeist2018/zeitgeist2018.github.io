package es.cristianlm.app.feature

import es.cristianlm.model.Language
import io.ktor.application.*
import io.ktor.sessions.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory

data class Session(
    val language: Language
) {
    companion object {
        val default = Session(Language.ENGLISH)
    }
}

class SessionFeature private constructor(
) {

    class Configuration

    private suspend fun onRequest(call: ApplicationCall, proceed: suspend () -> Unit) {
        if (call.sessions.get() == null) {
            call.sessions.start()
        }

        proceed()
    }


    companion object Feature : ApplicationFeature<Application, Configuration, SessionFeature> {
        override val key: AttributeKey<SessionFeature> = AttributeKey("sessionFeature")

        override fun install(pipeline: Application, configure: Configuration.() -> Unit): SessionFeature {
            val feature = SessionFeature()

            val phase = PipelinePhase("SessionFeature")
            pipeline.insertPhaseBefore(ApplicationCallPipeline.Call, phase)

            pipeline.intercept(phase) {
                withContext(coroutineContext) {
                    feature.onRequest(call, ::proceed)
                }
            }

            return feature
        }
    }
}

fun CurrentSession.start() {
    set("session", Session.default)
}

fun CurrentSession.get(): Session? = get("session")?.let { it as Session }

fun ApplicationCall.getLang(): Language =
    sessions.get("session")?.let { it as Session }?.language ?: throw IllegalStateException("Session not set?")
