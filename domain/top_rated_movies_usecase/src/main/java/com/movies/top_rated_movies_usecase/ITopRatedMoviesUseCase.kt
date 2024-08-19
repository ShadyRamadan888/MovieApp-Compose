package com.movies.top_rated_movies_usecase

import androidx.paging.PagingData
import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface ITopRatedMoviesUseCase {
    operator fun invoke(moviesCategory: String): Flow<List<Movie>>
}