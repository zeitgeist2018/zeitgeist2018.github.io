package es.cristianlm.gradle

import org.gradle.api.Project
import java.util.concurrent.TimeUnit

data class CommandOutput(
    val exitCode: Int,
    val stdout: String,
    val stderr: String
)

fun Project.execute(command: String): CommandOutput {
    val parts = command.split("\\s".toRegex())
    val proc = ProcessBuilder(*parts.toTypedArray())
        .directory(rootProject.projectDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()

    proc.waitFor(60, TimeUnit.MINUTES)
    return CommandOutput(
        proc.exitValue(),
        proc.inputStream.bufferedReader().readText(),
        proc.errorStream.bufferedReader().readText()
    )
}

