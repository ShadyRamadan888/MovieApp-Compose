package com.movies.watch.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movies.watch.R
import com.movies.watch.ui.theme.TransparentBackground

@Composable
fun CircleCardWithCenterImage(
    modifier: Modifier,
    imageResource: Int
) {
    Card(
        modifier = modifier
            .clip(CircleShape)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(TransparentBackground)
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
            )
        }
    }
}

@Composable
@Preview
fun PlayVideoSignPreview(){
    CircleCardWithCenterImage(
        modifier = Modifier,
        imageResource = R.drawable.baseline_play_arrow_24
    )
}