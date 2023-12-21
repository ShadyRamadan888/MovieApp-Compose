package com.movies.movies_usecase

import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface IMoviesWithSpecificCategoryUseCase {
    operator fun invoke(movieCategoryUrl: String): Flow<List<Movie>>
}