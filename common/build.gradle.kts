plugins {
    plugin.`java-conventions`
    `java-library`
}

dependencies {
    compileOnlyApi(libs.lombok)
    annotationProcessor(libs.lombok)
}