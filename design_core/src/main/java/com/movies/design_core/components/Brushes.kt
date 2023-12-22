package com.movies.design_core.components

import androidx.compose.ui.graphics.Brush
import com.movies.watch.ui.theme.FirstDegree
import com.movies.watch.ui.theme.SecondDegree
import com.movies.watch.ui.theme.ThirdDegree

val BasicBrush = Brush.verticalGradient(
    colors = listOf(
        FirstDegree,
        SecondDegree,
        ThirdDegree,
        SecondDegree
    )
)