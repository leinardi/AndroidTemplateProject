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

import com.leinardi.forlago.ext.AndroidConfigExt
import com.leinardi.forlago.ext.AppsConfigExt
import com.leinardi.forlago.ext.ConfigExt
import com.leinardi.forlago.ext.ForlagoAppsConfigExt
import com.leinardi.forlago.ext.ParamsConfigExt
import com.leinardi.forlago.ext.getOrNull


val config = extensions.create<ConfigExt>("config").apply {
    extensions.create<AndroidConfigExt>("android").apply {
        accountType.convention("com.leinardi.forlago.auth")
        compileSdk.convention(35)
        javaVersion.convention(JavaVersion.VERSION_17)
        minSdk.convention(29)
        targetSdk.convention(35)
    }

    extensions.create<AppsConfigExt>("apps").apply {
        extensions.create<ForlagoAppsConfigExt>("forlago").apply {
            applicationId.convention("com.leinardi.forlago")
            baseName.convention("forlago")
            deepLinkScheme.convention("forlago")
        }
    }

    extensions.create<ParamsConfigExt>("params").apply {
        saveBuildLogToFile.convention((rootProject.extra.getOrNull("saveBuildLogToFile") as? String).toBoolean())
    }
}
