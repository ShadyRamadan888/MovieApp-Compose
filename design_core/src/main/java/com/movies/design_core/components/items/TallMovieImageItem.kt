package com.movies.design_core.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.movies.design_core.components.shimmer.shimmerBrush
import com.movies.model.movie.Movie

@Composable
fun TallMovieImageItem(
    modifier: Modifier,
    movie: Movie,
    isLoading: Boolean = false
) {

    val showShimmer = remember { mutableStateOf(true) }

    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500\\" + movie.posterPath,
        contentDescription = null,
        modifier = modifier
            .background(shimmerBrush(targetValue = 1300f, showShimmer = showShimmer.value))
            .clip(RoundedCornerShape(10.dp))
            .width(140.dp)
            .height(200.dp),
        onSuccess = { showShimmer.value = false },
        contentScale = ContentScale.Crop
    )
}