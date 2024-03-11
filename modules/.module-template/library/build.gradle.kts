/*
 * Copyright 2024 Roberto Leinardi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("forlago.android-library-conventions")
    id("com.google.dagger.hilt.android")
}

android {
    namespace ="com.leinardi.forlago.library.@placeholderlowercase@"
    resourcePrefix = "@placeholder_snake_case@_"
    defaultConfig {
        consumerProguardFiles("$projectDir/proguard-@placeholderlowercase@-consumer-rules.pro")
    }
}

dependencies {
    implementation(projects.modules.library@PlaceholderName@Api)
    implementation(libs.hilt.android)

    ksp(libs.hilt.compiler)
}
