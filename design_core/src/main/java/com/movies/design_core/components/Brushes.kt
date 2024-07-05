package com.movies.design_core.components

import androidx.compose.ui.graphics.Brush
import com.movies.design_core.ui.theme.FirstDegree
import com.movies.design_core.ui.theme.SecondDegree
import com.movies.design_core.ui.theme.ThirdDegree

val BasicBrush = Brush.verticalGradient(
    colors = listOf(
        FirstDegree,
        SecondDegree,
        ThirdDegree,
        SecondDegree
    )
)