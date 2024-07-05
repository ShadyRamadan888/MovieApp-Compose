package com.movies.feature_home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.movies.feature_home.screens.HomeScreen


private const val ROUTE = "homeScreen"

fun NavController.navigateToHomeScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(
    navHostController: NavHostController
) {

    composable(ROUTE) {
        HomeScreen(
            navHostController = navHostController
        )
    }
}