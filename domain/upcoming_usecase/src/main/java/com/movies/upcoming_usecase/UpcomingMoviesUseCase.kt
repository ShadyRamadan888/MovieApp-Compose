package com.movies.upcoming_usecase

import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.flow.Flow

class UpcomingMoviesUseCase(
    private val moviesRepo: MoviesRepo
) : IUpcomingMoviesUseCase {
    override fun invoke(moviesCategory: String): Flow<List<Movie>> =
        moviesRepo.getMoviesWithCategoryUrl(moviesCategory)
}