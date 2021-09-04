package com.example.shubhamtimer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Orange600,
    primaryVariant = Orange900,
    secondary = GreenA500,
    secondaryVariant = GreenA700,
    background = Orange600,
    )

private val LightColorPalette = lightColors(
    primary = Amber600,
    primaryVariant = Amber800,
    secondary = GreenA700,
    secondaryVariant = GreenA500,
    background = Amber600

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ShubhamTimerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = if (darkTheme) {
        TypographyDark
    } else {
        TypographyLight
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content,
    )
}