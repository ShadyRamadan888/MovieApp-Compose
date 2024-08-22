package com.movies.design_core.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.movies.design_core.components.cards.MainMovieCard
import com.movies.design_core.components.progress_bars.CircularIndeterminateProgressBar
import com.movies.model.base.PagingUiState
import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

@Composable
fun GridMoviesVerticallySection(
    pagingMoviesUiState: PagingUiState
) {

    var lazyPagingItems by remember { mutableStateOf<LazyPagingItems<Movie>?>(null) }

    when (pagingMoviesUiState) {
        is PagingUiState.Loading -> {
            CircularIndeterminateProgressBar(true)
        }

        is PagingUiState.Success<*> -> {
            val pagingDataFlow = pagingMoviesUiState.data as Flow<PagingData<Movie>>
            lazyPagingItems = pagingDataFlow.collectAsLazyPagingItems()
            // Display the grid
            lazyPagingItems?.let {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(it.itemCount) { index ->
                        it[index]?.let { movie ->
                            MainMovieCard(movies = movie)
                        }
                    }
                }
            } ?: CircularIndeterminateProgressBar(true)
        }

        is PagingUiState.Error -> {
            CircularIndeterminateProgressBar(true)
        }
    }
}