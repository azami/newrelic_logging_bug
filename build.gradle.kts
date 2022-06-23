import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // NewRelic
    implementation("com.newrelic.agent.java:newrelic-agent:7.8.0")
    implementation("com.newrelic.agent.java:newrelic-api:7.8.0")
    implementation("com.newrelic.logging:logback:2.4.0")
    // ↓は問題ない
//    implementation("com.newrelic.logging:logback:2.3.2")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}
