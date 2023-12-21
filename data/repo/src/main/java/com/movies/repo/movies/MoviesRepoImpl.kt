package com.movies.repo.movies

import com.movies.model.movie.Movie
import com.movies.service.Constants
import com.movies.service.movie.MovieApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesRepoImpl(
    private val movieApiService: MovieApiService
) : MoviesRepo {
    override fun getPopularMovies(): Flow<List<Movie>> = flow {
        val response = movieApiService
            .getMoviesByCategory(Constants.MOVIES.POPULAR)
            .listOfMovies
        emit(response)
    }
}