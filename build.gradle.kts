
plugins {
    java
    kotlin("jvm") version "1.6.10"
    kotlin("kapt") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("versioning")
}

allprojects {
    repositories{
        google()
        mavenCentral()
    }
    group = "es.cristianlm"
}

println("Version: $version")

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
    apply(plugin = "versioning")

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.jvmTarget = "16"
        }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
        implementation("io.ktor:ktor-server-sessions:1.6.7")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
        implementation("com.google.dagger:dagger:2.41")
        kapt("com.google.dagger:dagger-compiler:2.41")

        implementation("org.slf4j:slf4j-api:1.7.25")
    }

}
