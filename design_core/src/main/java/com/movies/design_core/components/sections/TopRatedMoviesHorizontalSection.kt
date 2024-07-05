package com.movies.design_core.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movies.design_core.components.items.TallMovieImageItem
import com.movies.design_core.components.progress_bars.CircularIndeterminateProgressBar
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie

@Composable
fun TopRatedMovieHorizontalSection(
    modifier: Modifier = Modifier,
    loadTopRatedMoviesUiState: SectionUiState
) {

    var topRatedMovies by remember { mutableStateOf(emptyList<Movie>()) }
    var isTopRatedMoviesLoading by remember { mutableStateOf(true) }

    when (loadTopRatedMoviesUiState) {
        is SectionUiState.Loading -> isTopRatedMoviesLoading = true
        is SectionUiState.Success<*> -> {
            isTopRatedMoviesLoading = false
            topRatedMovies = loadTopRatedMoviesUiState.data as List<Movie>? ?: emptyList()
        }

        is SectionUiState.Error -> isTopRatedMoviesLoading = false
    }

    if (isTopRatedMoviesLoading) {
        CircularIndeterminateProgressBar(true)
    } else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
            )
        ) {
            items(topRatedMovies) { item ->
                TallMovieImageItem(
                    modifier = modifier,
                    item,
                )
            }
        }
    }
}