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
import com.movies.design_core.mock.movieItemsMock
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie
import com.movies.model.movie.MovieResponse

@Composable
fun PopularMovieHorizontalSection(
    modifier: Modifier = Modifier,
    loadPopularMoviesUiState: SectionUiState
) {

    var popularMovies by remember { mutableStateOf(emptyList<Movie>()) }
    var isPopularMoviesLoading by remember { mutableStateOf(true) }

    when (loadPopularMoviesUiState) {
        is SectionUiState.Loading -> isPopularMoviesLoading = true
        is SectionUiState.Success<*> -> {
            isPopularMoviesLoading = false
            popularMovies = loadPopularMoviesUiState.data as List<Movie>? ?: emptyList()
        }

        is SectionUiState.Error -> isPopularMoviesLoading = false
    }

    if (isPopularMoviesLoading) {
        CircularIndeterminateProgressBar(true)
    } else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
            )
        ) {
            items(popularMovies) { item ->
                TallMovieImageItem(
                    modifier = modifier,
                    item,
                )
            }
        }
    }
}