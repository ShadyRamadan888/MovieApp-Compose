package com.movies.design_core.components.sections

import android.util.Log
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
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie
import com.movies.model.movie.MovieResponse

@Composable
fun PopularMovieHorizontalSection(
    modifier: Modifier = Modifier,
    loadPopularMoviesUiState: SectionUiState
) {

    var movies by remember { mutableStateOf(emptyList<Movie>()) }
    var isMoviesLoading by remember { mutableStateOf(true) }
    var showMovies by remember { mutableStateOf(true) }

    when (loadPopularMoviesUiState) {
        is SectionUiState.Loading -> isMoviesLoading = true
        is SectionUiState.Success<*> -> {
            isMoviesLoading = false
            movies = loadPopularMoviesUiState.data as List<Movie>? ?: emptyList()
            Log.v("SHR",movies.toString())
            showMovies = movies.isNotEmpty()
        }

        is SectionUiState.Error -> isMoviesLoading = false
        is SectionUiState.Idle -> isMoviesLoading = false
    }

    if (showMovies) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
            )
        ) {
            items(movies) { item ->
                TallMovieImageItem(
                    modifier = modifier,
                    requireNotNull(item)
                )
            }
        }
    }
}