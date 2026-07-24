package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = DocBluePrimaryDark,
    secondary = DocBlueSecondaryDark,
    tertiary = DocBlueTertiaryDark,
    background = BackgroundDark,
    surface = SurfaceDark
  )

private val LightColorScheme =
  lightColorScheme(
    primary = DocBluePrimary,
    secondary = DocBlueSecondary,
    tertiary = DocBlueTertiary,
    background = BackgroundLight,
    surface = SurfaceLight
  )

@Composable
fun DocFusionTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}

// Retain alias for backward compatibility or test runner references if needed
@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit,
) {
  DocFusionTheme(darkTheme = darkTheme, dynamicColor = dynamicColor, content = content)
}

