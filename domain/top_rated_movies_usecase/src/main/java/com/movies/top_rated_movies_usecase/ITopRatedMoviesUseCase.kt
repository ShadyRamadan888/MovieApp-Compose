package com.movies.top_rated_movies_usecase

import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface ITopRatedMoviesUseCase {
    operator fun invoke(moviesCategory: String): Flow<List<Movie>>
}