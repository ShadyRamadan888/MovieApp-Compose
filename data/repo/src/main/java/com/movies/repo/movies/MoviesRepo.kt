package com.movies.repo.movies

import com.movies.model.movie.Movie
import com.movies.model.movie.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MoviesRepo {
    fun getPopularMovies(): Flow<List<Movie>>
}