package com.leinardi.forlago.library.android.api.ext

import android.graphics.Color
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge

fun ComponentActivity.enableEdgeToEdgeCompat(
    statusBarStyle: SystemBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT),
    navigationBarStyle: SystemBarStyle = SystemBarStyle.auto(navigationBarDefaultLightScrim, navigationBarDefaultDarkScrim),
    isNavigationBarContrastEnforced: Boolean = false,
) {
    enableEdgeToEdge(statusBarStyle, navigationBarStyle)
    // For API29(Q) or higher and 3-button navigation,
    // the following code must be written to make the navigation color completely transparent.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = isNavigationBarContrastEnforced
    }
}

/**
 * The default light scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=35-38;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
val navigationBarDefaultLightScrim = Color.argb(0xe6, 0xFF, 0xFF, 0xFF)

/**
 * The default dark scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=40-44;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
val navigationBarDefaultDarkScrim = Color.argb(0x80, 0x1b, 0x1b, 0x1b)
