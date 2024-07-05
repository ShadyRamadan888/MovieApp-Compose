package com.movies.design_core.components.texts

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movies.design_core.ui.theme.BasicBackground1
import com.movies.design_core.ui.theme.GrayText
import com.movies.watch.ui.theme.ReggaeOne


@Composable
fun RaggaeText(
    text: String
){
    Text(
        text = text,
        fontFamily = ReggaeOne,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(16.dp)
    )
}