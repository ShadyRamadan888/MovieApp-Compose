package com.movies.watch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.movies.design_core.ui.theme.WatchAppTheme
import com.movies.feature_home.screens.MockScreen
import com.movies.watch.navigation.MoviesNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchAppTheme {
                val navController = rememberNavController()
                MoviesNavGraph(navHostController = navController)
            }
        }

    }
}

