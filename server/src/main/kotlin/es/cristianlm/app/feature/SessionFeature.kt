package es.cristianlm.app.feature

import es.cristianlm.model.Language
import io.ktor.application.*
import io.ktor.sessions.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.withContext

data class Session(
    val language: Language
) {
    companion object {
        const val name = "session"
        val default = Session(Language.default)
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
    set(Session.name, Session.default)
}

fun CurrentSession.get(): Session? = get(Session.name)?.let { it as Session }

fun ApplicationCall.getLang(): Language =
    sessions.get(Session.name)?.let { it as Session }?.language ?: throw IllegalStateException("Session not set?")

fun ApplicationCall.setLang(language: Language) = sessions.set(Session.name, Session(language))
