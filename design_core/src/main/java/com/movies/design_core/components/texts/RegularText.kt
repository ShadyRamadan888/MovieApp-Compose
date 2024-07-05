package com.movies.design_core.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.movies.watch.ui.theme.Poppins

@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 8.sp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        color = color,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}