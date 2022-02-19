package es.cristianlm.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersioningPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.plugins.hasPlugin(VersioningPlugin::class.java)) {
            project.getLastGitTag()
            when (val gitBranch = project.getGitBranch()) {
                "master" -> project.version = project.getLastGitTag()
                else -> project.version = "$gitBranch-SNAPSHOT"
            }
        }
    }
}
