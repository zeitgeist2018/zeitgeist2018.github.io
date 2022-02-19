import org.apache.tools.ant.filters.ReplaceTokens
import java.net.InetAddress
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

dependencies {
    implementation("com.typesafe:config:1.4.2")
    implementation("com.zaxxer:HikariCP:5.0.1")

    implementation("io.ktor:ktor-server-core:1.6.7")
    implementation("io.ktor:ktor-jackson:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("io.ktor:ktor-webjars:1.6.7")
    implementation("io.ktor:ktor-thymeleaf:1.6.7")
    implementation("io.arrow-kt:arrow-core:1.0.1")

    implementation("ch.qos.logback:logback-classic:1.2.10")
    implementation("org.codehaus.janino:janino:3.1.6")
    implementation("net.logstash.logback:logstash-logback-encoder:6.4")
}

tasks.processResources {
    from(sourceSets["main"].resources.srcDirs)
    into("$buildDir/resources/main")
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    filesMatching("application.conf") {
        filter(
            ReplaceTokens::class, "tokens" to mapOf(
                "BUILD_VERSION" to version,
                "BUILD_DATE" to DateTimeFormatter.ISO_DATE_TIME.format(ZonedDateTime.now()),
                "BUILD_MACHINE" to InetAddress.getLocalHost().hostName
            )
        )
    }
}

tasks.register<JavaExec>("run") {
    main = "es.cristianlm.Boot"
    classpath = sourceSets["main"].runtimeClasspath
    workingDir = rootProject.projectDir
}
