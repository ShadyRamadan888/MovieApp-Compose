package com.movies.top_rated_movies_usecase.di

import com.movies.top_rated_movies_usecase.ITopRatedMoviesUseCase
import com.movies.top_rated_movies_usecase.TopRatedMoviesUseCase
import org.koin.dsl.module

val topRatedMoviesModule = module {
    single<ITopRatedMoviesUseCase> {
        TopRatedMoviesUseCase(get())
    }
}