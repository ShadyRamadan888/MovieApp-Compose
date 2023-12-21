package com.movies.movies_usecase

import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.flow.Flow

class MoviesWithSpecificCategoryUseCase(
    private val moviesRepo: MoviesRepo
) : IMoviesWithSpecificCategoryUseCase {
    override fun invoke(movieCategoryUrl: String): Flow<List<Movie>> =
        moviesRepo.getMoviesWithCategoryUrl(
            categoryUrl = movieCategoryUrl
        )
}