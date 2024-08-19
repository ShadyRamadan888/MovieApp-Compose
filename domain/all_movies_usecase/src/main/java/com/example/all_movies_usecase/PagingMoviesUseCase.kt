package com.example.all_movies_usecase

import androidx.paging.PagingData
import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.flow.Flow

class PagingMoviesUseCase(
    private val moviesRepo: MoviesRepo
): IPagingMoviesUseCase {
    override fun invoke(category: String): Flow<PagingData<Movie>> =
        moviesRepo.getPagingMoviesByCategory(category)
}