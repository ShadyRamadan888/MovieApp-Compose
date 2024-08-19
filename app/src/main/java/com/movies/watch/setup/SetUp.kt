package com.movies.watch.setup

import android.content.Context
import com.example.all_movies_usecase.di.pagingMoviesModule
import com.movies.movies_usecase.di.PopularMoviesUseCaseModule
import com.movies.now_playing_usecase.di.nowPlayingModule
import com.movies.repo.di.repoModule
import com.movies.service.di.serviceModule
import com.movies.top_rated_movies_usecase.di.topRatedMoviesModule
import com.movies.upcoming_usecase.di.upcomingMoviesModule
import com.movies.watch.di.viewModelModule
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
    serviceModule,
    PopularMoviesUseCaseModule,
    topRatedMoviesModule,
    viewModelModule,
    nowPlayingModule,
    upcomingMoviesModule,
    pagingMoviesModule
)
