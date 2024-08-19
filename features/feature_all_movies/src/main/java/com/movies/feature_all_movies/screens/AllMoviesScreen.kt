package com.movies.feature_all_movies.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.movies.feature_all_movies.screens.composables.AllMoviesContent
import com.movies.service.Constants
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllMoviesScreen(
    navHostController: NavHostController,
    viewModel: AllMoviesViewModel = koinViewModel(),
    category: String
) {

    AllMoviesContent(
        category = category,
        moviePagingItems = when (category) {
            Constants.MoviesIdentifier.UPCOMING -> viewModel.upcomingMovies.collectAsLazyPagingItems()
            Constants.MoviesIdentifier.TOP_RATED -> viewModel.topRatedMovies.collectAsLazyPagingItems()
            Constants.MoviesIdentifier.NOW_PLAYING -> viewModel.nowPlayingMovies.collectAsLazyPagingItems()
            Constants.MoviesIdentifier.POPULAR -> viewModel.popularMovies.collectAsLazyPagingItems()
            else -> viewModel.popularMovies.collectAsLazyPagingItems()
        },
        navController = navHostController
    )
}