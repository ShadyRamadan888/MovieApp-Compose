package com.movies.upcoming_usecase

import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface IUpcomingMoviesUseCase {
    operator fun invoke(moviesCategory: String): Flow<List<Movie>>
}