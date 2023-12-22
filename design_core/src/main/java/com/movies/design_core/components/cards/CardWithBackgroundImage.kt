package com.movies.design_core.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movies.design_core.R


@Composable
fun CardWithBackgroundWideImage() {

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.cover_test),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            CircleCardWithCenterImage(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp),
                imageResource = R.drawable.baseline_play_arrow_24
            )
            CardWithTwoVerticalTexts(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                "Five Nights",
                "at Freddy's"
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun CardWithBackgroundImagePreview() {
    CardWithBackgroundWideImage()
}