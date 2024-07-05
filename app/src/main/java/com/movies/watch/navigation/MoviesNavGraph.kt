package com.movies.watch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.movies.feature_home.navigation.homeRoute
import com.movies.feature_home.screens.allMoviesRoute

@Composable
fun MoviesNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        startDestination = "homeScreen",
        navController = navHostController
    ) {
        allMoviesRoute(navHostController)
        homeRoute(navHostController = navHostController)
    }
}