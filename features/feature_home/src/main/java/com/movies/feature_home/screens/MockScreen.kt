package com.movies.feature_home.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.movies.design_core.components.sections.GridMoviesVerticallySection
import com.movies.repo.movies.MoviesRepo
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.compose.viewModel
import org.koin.compose.koinInject

@Composable
fun MockScreen() {

    val repo: MoviesRepo = koinInject()
    val lazyItem = repo.streamMovies().collectAsLazyPagingItems()

    GridMoviesVerticallySection(lazyItem)

}