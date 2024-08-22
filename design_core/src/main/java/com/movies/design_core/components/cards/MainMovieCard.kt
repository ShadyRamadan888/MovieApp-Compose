package com.movies.design_core.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.movies.design_core.R
import com.movies.model.movie.Movie

@Composable
fun MainMovieCard(
    movies: Movie
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500\\" + movies.posterPath,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .width(140.dp)
                .height(150.dp),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.placeholder_image)
        )
    }
}