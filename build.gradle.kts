plugins {
    kotlin("jvm") version "2.3.0"
    application

    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // Source: https://mvnrepository.com/artifact/org.openjfx/javafx-controls
    implementation("org.openjfx:javafx-controls:27-ea+6")
    // Coroutines de base
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    // Support Android pour les coroutines (Dispatchers.Main)
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    // ... autres dépendances (ViewModel, etc.)
    //implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    //implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
