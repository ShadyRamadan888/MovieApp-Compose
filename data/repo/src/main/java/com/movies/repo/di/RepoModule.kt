package com.movies.repo.di

import com.movies.repo.movies.MoviesRepo
import com.movies.repo.movies.MoviesRepoImpl
import org.koin.dsl.module


val repoModule = module {
    single<MoviesRepo> {
        MoviesRepoImpl(get())
    }
}