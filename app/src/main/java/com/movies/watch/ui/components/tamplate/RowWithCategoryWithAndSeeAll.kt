package com.movies.watch.ui.components.tamplate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movies.watch.ui.components.texts.RegularText
import com.movies.watch.ui.theme.GrayText


@Composable
fun RowWithCategoryAndSeeAll(
    categoryName: String,
) {
    Spacer(Modifier.height(5.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(85f),
        ) {
            RegularText(
                text = categoryName,
                fontSize = 17.sp,
                color = GrayText,
            )
        }
        Box(
            modifier = Modifier
                .weight(15f)
                .align(Alignment.CenterVertically)
        ) {
            RegularText(
                text = "SeeAll",
                fontSize = 12.sp,
                color = GrayText
            )
        }
    }
}