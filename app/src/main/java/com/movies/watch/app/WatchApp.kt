package com.movies.watch.app

import android.app.Application
import android.util.Log
import androidx.paging.compose.collectAsLazyPagingItems
import com.movies.feature_home.screens.HomeViewModel
import com.movies.repo.movies.MoviesRepo
import com.movies.watch.setup.initStartupComponents
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel

class WatchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        this.initStartupComponents()

    }
}