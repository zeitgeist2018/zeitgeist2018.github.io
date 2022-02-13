
plugins {
    java
    kotlin("jvm") version "1.6.0"
    kotlin("kapt") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.0"
}

allprojects {
    repositories{
        google()
        mavenCentral()
    }
    group = "es.cristianlm"
}

//println("Version: $version")

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.jvmTarget = "16"
        }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
        implementation("io.ktor:ktor-server-sessions:1.6.0")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
        implementation("com.google.dagger:dagger:2.40.1")
        kapt("com.google.dagger:dagger-compiler:2.40.1")

        implementation("org.slf4j:slf4j-api:1.7.25")
    }

}
