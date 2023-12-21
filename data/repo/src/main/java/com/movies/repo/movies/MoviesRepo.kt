package com.movies.repo.movies

import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepo {
    fun getMoviesWithCategoryUrl(categoryUrl: String): Flow<List<Movie>>
}