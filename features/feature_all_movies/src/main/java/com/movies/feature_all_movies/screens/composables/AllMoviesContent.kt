package com.movies.feature_all_movies.screens.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.PagingData
import com.movies.design_core.components.sections.GridMoviesVerticallySection
import com.movies.design_core.components.toolbar.MainToolbar
import com.movies.design_core.extensions.capitalizeFirstLetterOfEachWord
import com.movies.model.base.PagingUiState
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

@Composable
fun AllMoviesContent(
    category: String,
    pagingMoviesUiState: PagingUiState,
    navController: NavController
) {
    AllMoviesBody(
        category = category,
        pagingMoviesUiState = pagingMoviesUiState,
        navController = navController
    )
}

@Composable
fun AllMoviesBody(
    category: String,
    pagingMoviesUiState:  PagingUiState,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        MainToolbar(
            title = category
                .replace("_", " ")
                .capitalizeFirstLetterOfEachWord(), navController = navController
        )
        GridMoviesVerticallySection(pagingMoviesUiState)
    }
}

