package com.movies.now_playing_usecase

import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface INowPlayingMoviesUseCase {
    operator fun invoke(moviesCategory: String): Flow<List<Movie>>
}