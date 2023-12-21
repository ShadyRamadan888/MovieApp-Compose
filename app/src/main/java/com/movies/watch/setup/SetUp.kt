package com.movies.watch.setup

import android.content.Context
import com.movies.repo.di.repoModule
import com.movies.service.di.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

fun Context.initStartupComponents() {

    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initStartupComponents)
        modules(getKoinModules())
    }
}

private fun getKoinModules(): List<Module> = listOf(
    repoModule,
    serviceModule
)
