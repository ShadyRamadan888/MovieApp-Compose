package com.movies.design_core.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.movies.design_core.components.cards.MainMovieCard
import com.movies.model.movie.Movie

@Composable
fun GridMoviesVerticallySection(
    moviePagingItems: LazyPagingItems<Movie>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(moviePagingItems.itemCount) {
            MainMovieCard(movies = moviePagingItems[it]!!)
        }
    }
}