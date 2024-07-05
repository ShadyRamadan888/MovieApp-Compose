package com.movies.design_core.components.items

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.movies.design_core.R
import com.movies.model.movie.Movie

@Composable
fun TallMovieImageItem(
    modifier: Modifier,
    movie: Movie,
) {

    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500\\" + movie.posterPath,
        contentDescription = null,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .width(140.dp)
            .height(200.dp),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.placeholder_image)
    )


}

