package com.movies.watch.ui.components.tamplate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.movies.watch.ui.components.Movie
import com.movies.watch.ui.components.cards.TallMovieImageItem


@Composable
fun HomeMovieBasicLazyRow(
    movieList: List<Movie>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
        )
    ) {
        items(movieList) {
            TallMovieImageItem(it.poster_path)
        }
    }

}