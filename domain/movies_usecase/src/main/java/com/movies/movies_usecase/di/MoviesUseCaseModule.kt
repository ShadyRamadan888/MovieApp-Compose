package com.movies.movies_usecase.di

import com.movies.movies_usecase.IMoviesWithSpecificCategoryUseCase
import com.movies.movies_usecase.MoviesWithSpecificCategoryUseCase
import org.koin.dsl.module

val moviesUseCaseModule = module {
    single<IMoviesWithSpecificCategoryUseCase> {
        MoviesWithSpecificCategoryUseCase(get())
    }
}