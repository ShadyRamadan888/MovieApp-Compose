package com.movies.design_core.components.tamplate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.movies.design_core.components.cards.TallMovieImageItem
import com.movies.model.movie.Movie


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
       items(movieList){
           TallMovieImageItem(it.backdropPath!!)
       }
    }

}