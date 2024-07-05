package com.movies.design_core.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

//Background
val FirstDegree = Color(0xFFC90404)
val SecondDegree = Color(0xFF000000)
val ThirdDegree = Color(0xFF430707)
val BasicBackground1 = Color(0xFF090F1A)

val TransparentBackground = Color(0x1AFFFFFF)
val LargeTextColor = Color(0xFFFF0000)
val GrayText = Color(0xFFDBDBDB)

//app top
val TopApp = Color(0x90A50C1E)

//Dark theme colors
val BackgroundDark = Color(0xFF090F1A)
val PrimaryDark = Color(0xFFFFFFFF)

//Light theme colors
val BackgroundLight = Color(0xFFFFFFFF)
val PrimaryLight = Color(0xFF090F1A)

sealed class ThemeColors(
    val background: Color,
    val primary: Color,
    //Other colors needed
) {
    object Light : ThemeColors(
        background = BackgroundLight,
        primary = PrimaryLight,
    )

    object Dark : ThemeColors(
        background = BackgroundDark,
        primary = PrimaryDark
    )
}