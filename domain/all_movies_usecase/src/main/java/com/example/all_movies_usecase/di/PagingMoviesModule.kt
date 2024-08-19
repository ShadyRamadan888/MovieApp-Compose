package com.example.all_movies_usecase.di

import com.example.all_movies_usecase.IPagingMoviesUseCase
import com.example.all_movies_usecase.PagingMoviesUseCase
import org.koin.dsl.module


val pagingMoviesModule = module {
    single<IPagingMoviesUseCase> {
        PagingMoviesUseCase(get())
    }
}