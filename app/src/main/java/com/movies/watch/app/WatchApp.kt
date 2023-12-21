package com.movies.watch.app

import android.app.Application
import android.util.Log
import com.movies.repo.movies.MoviesRepo
import com.movies.watch.setup.initStartupComponents
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class WatchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        this.initStartupComponents()

    }
}