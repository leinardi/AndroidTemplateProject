plugins {
    id("forlago.android-library-conventions")
}

android {
    namespace = "com.leinardi.forlago.feature.account.api"
    resourcePrefix = "account_api_"
    defaultConfig {
        consumerProguardFiles("$projectDir/proguard-account-api-consumer-rules.pro")
    }
}

dependencies {
    implementation(projects.modules.libraryNavigationApi)
    implementation(projects.modules.libraryNetworkApi)
}
