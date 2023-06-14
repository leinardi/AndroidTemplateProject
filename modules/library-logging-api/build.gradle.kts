plugins {
    id("forlago.android-library-conventions")
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.leinardi.forlago.library.logging.api"
    resourcePrefix = "logging_api_"
    defaultConfig {
        consumerProguardFiles("$projectDir/proguard-logging-api-consumer-rules.pro")
    }
}

dependencies {
    implementation(libs.kotlinx.serialization)
}
