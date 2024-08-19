package com.movies.feature_all_movies.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.movies.feature_all_movies.screens.AllMoviesScreen

private const val ROUTE = "allMoviesScreen"

fun NavController.navigateToAllMoviesScreen(categoryName: String) {
    navigate("$ROUTE/$categoryName")
}

fun NavGraphBuilder.allMoviesRoute(
    navHostController: NavHostController,
) {
    composable(
        "$ROUTE/{${AllMoviesArguments.CATEGORY}}",
        arguments = listOf(
            navArgument(AllMoviesArguments.CATEGORY) { NavType.StringType }
        )
    ) {
        val category = it.arguments?.getString(AllMoviesArguments.CATEGORY)
        AllMoviesScreen(
            navHostController = navHostController,
            category = checkNotNull(category),
        )
    }
}

class AllMoviesArguments(savedStateHandle: SavedStateHandle) {
    val category: String = checkNotNull(savedStateHandle[CATEGORY])

    companion object {
        const val CATEGORY = "category"
    }
}