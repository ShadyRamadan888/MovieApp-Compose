package com.movies.feature_home.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.movies.feature_home.screens.composables.HomeContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val loadPopularMoviesUiState =
        viewModel.loadPopularMoviesUiState.collectAsStateWithLifecycle().value
    val loadTopRatedUiState =
        viewModel.loadTopRatedMoviesUiState.collectAsStateWithLifecycle().value

    HomeContent(
        loadPopularMoviesUiState = loadPopularMoviesUiState,
        loadTopRatedMoviesUiState = loadTopRatedUiState
    )
}