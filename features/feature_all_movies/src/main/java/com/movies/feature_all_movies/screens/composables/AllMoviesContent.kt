package com.movies.feature_all_movies.screens.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import com.movies.design_core.components.sections.GridMoviesVerticallySection
import com.movies.design_core.components.toolbar.MainToolbar
import com.movies.design_core.extensions.capitalizeFirstLetterOfEachWord
import com.movies.model.movie.Movie

@Composable
fun AllMoviesContent(
    category: String,
    moviePagingItems: LazyPagingItems<Movie>,
    navController: NavController
) {
    AllMoviesBody(
        category = category,
        moviePagingItems = moviePagingItems,
        navController = navController
    )
}

@Composable
fun AllMoviesBody(
    category: String,
    moviePagingItems: LazyPagingItems<Movie>,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainToolbar(
            title = category
                .replace("_", " ")
                .capitalizeFirstLetterOfEachWord(), navController = navController
        )
        GridMoviesVerticallySection(moviePagingItems)
    }
}

