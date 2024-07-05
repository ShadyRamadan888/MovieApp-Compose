package com.movies.upcoming_usecase.di

import com.movies.upcoming_usecase.IUpcomingMoviesUseCase
import com.movies.upcoming_usecase.UpcomingMoviesUseCase
import org.koin.dsl.module

val upcomingMoviesModule = module {
    single<IUpcomingMoviesUseCase> {
        UpcomingMoviesUseCase(get())
    }
}