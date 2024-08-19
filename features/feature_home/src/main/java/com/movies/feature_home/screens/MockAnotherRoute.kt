package com.movies.feature_home.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

//
//private const val ROUTE = "allMoviesScreen"
//
//fun NavController.navigateToAllMoviesScreen(categoryName: String) {
//    navigate("$ROUTE/$categoryName")
//    Log.v("SHR", categoryName)
//}
//
//fun NavGraphBuilder.allMoviesRoute(
//    navHostController: NavHostController,
//) {
//    composable(
//        "$ROUTE/{${AllMoviesArguments.CATEGORY}}",
//        arguments = listOf(
//            navArgument(AllMoviesArguments.CATEGORY) { NavType.StringType }
//        )
//    ) {
//        MockScreen(
//            AllMoviesArguments.CATEGORY,
//            navHostController
//        )
//    }
//}

//class AllMoviesArguments(savedStateHandle: SavedStateHandle) {
//    val category: String = checkNotNull(savedStateHandle[CATEGORY])
//
//    companion object {
//        const val CATEGORY = "category"
//    }
//}

//@Composable
//fun MockScreen(
//    categoryName: String,
//    navHostController: NavHostController
//) {
//    Text(categoryName)
//}

