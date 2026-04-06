plugins {
    java
    kotlin("jvm") version "2.0.21"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runJavaMain") {
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("JavaMain")
}

tasks.register<JavaExec>("runKotlinMain") {
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("KotlinMainKt")
}
