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
import com.movies.design_core.components.progress_bars.CircularIndeterminateProgressBar
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie

@Composable
fun UpcomingMovieHorizontalSection(
    modifier: Modifier = Modifier,
    loadUpcomingMoviesUiState: SectionUiState
) {

    var upcomingMovies by remember { mutableStateOf(emptyList<Movie>()) }
    var isUpcomingMoviesLoading by remember { mutableStateOf(true) }


    when (loadUpcomingMoviesUiState) {
        is SectionUiState.Loading -> isUpcomingMoviesLoading = true
        is SectionUiState.Success<*> -> {
            isUpcomingMoviesLoading = false
            upcomingMovies = loadUpcomingMoviesUiState.data as List<Movie>? ?: emptyList()
        }

        is SectionUiState.Error -> isUpcomingMoviesLoading = false
    }

    if (isUpcomingMoviesLoading) {
        CircularIndeterminateProgressBar(true)
    } else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
            )
        ) {
            items(upcomingMovies) { item ->
                TallMovieImageItem(
                    modifier = modifier,
                    item,
                )
            }
        }
    }
}