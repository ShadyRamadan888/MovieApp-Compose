package com.example.all_movies_usecase

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.map
import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PagingMoviesUseCase(
    private val moviesRepo: MoviesRepo
): IPagingMoviesUseCase {
    override fun invoke(category: String): Flow<PagingData<Movie>> {
        return moviesRepo.getPagingMoviesByCategory(category)
    }
}