package com.movies.movies_usecase.di

import com.movies.movies_usecase.IPopularMoviesUseCase
import com.movies.movies_usecase.PopularMoviesUseCase
import org.koin.dsl.module

val PopularMoviesUseCaseModule = module {
    single<IPopularMoviesUseCase> {
        PopularMoviesUseCase(get())
    }
}