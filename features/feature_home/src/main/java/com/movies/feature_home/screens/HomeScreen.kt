package com.movies.feature_home.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.movies.feature_all_movies.navigation.navigateToAllMoviesScreen
import com.movies.feature_home.navigation.HomeEffect
import com.movies.feature_home.navigation.HomeEvent
import com.movies.feature_home.screens.composables.HomeContent
import com.movies.model.base.SectionUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = koinViewModel()
) {

    HomeContent(
        loadPopularMoviesUiState = viewModel.popularMoviesUiState.collectAsStateWithLifecycle().value,
        loadTopRatedMoviesUiState = viewModel.topRatedMoviesUiState.collectAsStateWithLifecycle().value,
        loadNowPlayingMoviesUiState = viewModel.nowPlayingMoviesUiState.collectAsStateWithLifecycle().value,
        loadUpcomingMoviesUiState = viewModel.upcomingMoviesUiState.collectAsStateWithLifecycle().value,
        onSeeAllClicked = fun(parameter) {
            navHostController.navigateToAllMoviesScreen(parameter)
        },
    )
}