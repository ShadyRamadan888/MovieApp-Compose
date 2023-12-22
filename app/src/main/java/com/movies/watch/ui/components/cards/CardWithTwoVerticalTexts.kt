package com.movies.watch.ui.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movies.watch.ui.components.texts.RegularText
import com.movies.watch.ui.theme.LargeTextColor
import com.movies.watch.ui.theme.ReggaeOne
import com.movies.watch.ui.theme.TransparentBackground


@Composable
fun CardWithTwoVerticalTexts(
    modifier: Modifier,
    largeText: String,
    smallText: String
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .wrapContentSize(),
        colors = CardDefaults.cardColors(TransparentBackground)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = largeText,
                fontFamily = ReggaeOne,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                color = LargeTextColor
            )
            RegularText(
                text = smallText,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun CardWithVerticalTextsPreview() {
    CardWithTwoVerticalTexts(
        Modifier,
        "Harry Potter",
        "and the cursed child"
    )
}