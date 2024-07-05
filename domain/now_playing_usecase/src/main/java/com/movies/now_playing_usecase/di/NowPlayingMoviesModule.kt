package com.movies.now_playing_usecase.di

import com.movies.now_playing_usecase.INowPlayingMoviesUseCase
import com.movies.now_playing_usecase.NowPlayingMoviesUseCase
import org.koin.dsl.module

val nowPlayingModule = module {
    single<INowPlayingMoviesUseCase> {
        NowPlayingMoviesUseCase(get())
    }
}