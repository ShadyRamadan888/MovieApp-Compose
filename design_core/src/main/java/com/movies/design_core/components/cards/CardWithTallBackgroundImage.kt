package com.movies.design_core.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun TallMovieImageItem(
    imageUrl: String
) {
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = null,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(140.dp)
            .height(200.dp),
        contentScale =ContentScale.Crop
    )

}

@Composable
@Preview
fun CardWithTallBackgroundWideImagePreview() {
    TallMovieImageItem("")
}