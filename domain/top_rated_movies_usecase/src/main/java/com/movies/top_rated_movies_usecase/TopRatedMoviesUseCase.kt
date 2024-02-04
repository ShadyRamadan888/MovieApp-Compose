package com.movies.top_rated_movies_usecase

import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.flow.Flow

internal class TopRatedMoviesUseCase(
    private val moviesRepo: MoviesRepo
) : ITopRatedMoviesUseCase {
    override fun invoke(moviesCategory: String): Flow<List<Movie>> =
        moviesRepo.getMoviesWithCategoryUrl(moviesCategory)
}