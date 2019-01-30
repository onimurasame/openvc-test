import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.7"
}

group = "com.onimurasame"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven (url = "http://clojars.org/repo")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.openpnp:opencv:3.2.0-1")
    compile("org.springframework:spring-context:5.1.4.RELEASE")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "com.onimurasame.opencv.OpenCvTest"
}

javafx {
    modules = listOf("javafx.controls", "javafx.graphics")
}