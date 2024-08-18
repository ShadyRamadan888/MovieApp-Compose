package com.movies.watch.app

import android.app.Application
import com.movies.watch.setup.initStartupComponents

class WatchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        this.initStartupComponents()

    }
}