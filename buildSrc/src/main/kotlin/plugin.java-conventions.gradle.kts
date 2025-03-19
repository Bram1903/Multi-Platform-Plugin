plugins {
    java
}

group = rootProject.group
version = rootProject.version
description = rootProject.description

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:23.0.0")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
    disableAutoTargetJvm()
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release = 21
    }

    processResources {
        inputs.property("version", version)
        inputs.property("description", description)
        filesMatching(listOf("plugin.yml", "velocity-plugin.json")) {
            expand(
                "version" to version,
                "description" to description
            )
        }
    }

    defaultTasks("build")
}