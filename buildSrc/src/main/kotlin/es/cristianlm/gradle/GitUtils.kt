package es.cristianlm.gradle

import org.gradle.api.GradleException
import org.gradle.api.Project

fun Project.getGitBranch(): String {
    val result = project.execute("git rev-parse --abbrev-ref HEAD")

    return if (result.exitCode != 0) {
        throw GradleException("Couldn't get git branch")
    } else {
        cleanBranch(result.stdout)
    }
}

fun Project.getLastGitTag(): String {
    val tag = project.execute("git tag --sort=creatordate | tail -n1")
    println("TAG: $tag")
    return tag.stdout.ifEmpty { "0.0.0" }
}

private fun cleanBranch(rawBranch: String): String =
    rawBranch
        .replace("/", "-")
        .replace(" ", "_")
        .replace("\n", "")
        .replace("\r", "")
        .toLowerCase()
        .trim()
