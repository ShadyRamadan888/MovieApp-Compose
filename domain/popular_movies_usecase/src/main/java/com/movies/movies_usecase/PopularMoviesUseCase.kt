package com.movies.movies_usecase

import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.flow.Flow

internal class PopularMoviesUseCase(
    private val moviesRepo: MoviesRepo
) : IPopularMoviesUseCase {
    override fun invoke(movieCategoryUrl: String): Flow<List<Movie>> =
        moviesRepo.getMoviesWithCategoryUrl(
            categoryUrl = movieCategoryUrl
        )
}