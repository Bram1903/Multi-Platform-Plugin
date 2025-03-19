plugins {
    plugin.`java-conventions`
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.velocity)
}

repositories {
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    implementation(project(":common"))
    compileOnly(libs.velocity)
    annotationProcessor(libs.velocity)
    annotationProcessor(libs.lombok)
}

tasks {
    register("generateTemplates")

    jar {
        enabled = false
    }

    shadowJar {
        archiveFileName = "${rootProject.name}-Velocity-${version}.jar"
        archiveClassifier = null
    }

    assemble {
        dependsOn(shadowJar)
    }

    runVelocity {
        velocityVersion("3.3.0-SNAPSHOT")
        runDirectory = layout.projectDirectory.dir("run/$version")

        javaLauncher = project.javaToolchains.launcherFor {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }
}
