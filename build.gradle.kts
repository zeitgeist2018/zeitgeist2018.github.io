
plugins {
    java
    kotlin("jvm") version "1.5.21"
    kotlin("kapt") version "1.5.21"
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

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.jvmTarget = "15"
        }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.21")
        implementation("com.google.dagger:dagger:2.38")
        kapt("com.google.dagger:dagger-compiler:2.38")

        implementation("org.slf4j:slf4j-api:1.7.25")
    }

}
