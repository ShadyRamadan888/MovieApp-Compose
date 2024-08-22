package com.movies.feature_all_movies.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.movies.feature_all_movies.screens.composables.AllMoviesContent
import com.movies.model.base.SectionUiState
import com.movies.service.Constants
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllMoviesScreen(
    navHostController: NavHostController,
    viewModel: AllMoviesViewModel = koinViewModel(),
    category: String
) {
    val state by viewModel.pagingMoviesUiState.collectAsState()


    LaunchedEffect(category) {
        viewModel.loadPagingMovies(category)
    }

    AllMoviesContent(
        category = category,
        pagingMoviesUiState = state,
        navController = navHostController
    )
}