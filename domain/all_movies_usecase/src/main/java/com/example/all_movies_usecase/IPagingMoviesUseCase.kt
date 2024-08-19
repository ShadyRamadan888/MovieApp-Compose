package com.example.all_movies_usecase

import androidx.paging.PagingData
import com.movies.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface IPagingMoviesUseCase {
    operator fun invoke(category: String): Flow<PagingData<Movie>>
}