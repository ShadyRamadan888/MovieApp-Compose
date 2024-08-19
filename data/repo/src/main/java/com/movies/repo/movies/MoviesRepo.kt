package com.movies.repo.movies

import androidx.paging.PagingData
import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepo {
    fun getMoviesWithCategoryUrl(categoryUrl: String): Flow<List<Movie>>
    fun getPagingMoviesByCategory(category: String): Flow<PagingData<Movie>>
}