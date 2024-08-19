package com.movies.feature_all_movies.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.all_movies_usecase.IPagingMoviesUseCase
import com.movies.model.movie.Movie
import com.movies.service.Constants
import kotlinx.coroutines.flow.Flow

class AllMoviesViewModel(
    allPagingMoviesUseCase: IPagingMoviesUseCase
) : ViewModel() {

    val nowPlayingMovies: Flow<PagingData<Movie>> =
        allPagingMoviesUseCase.invoke(Constants.MoviesIdentifier.NOW_PLAYING)
            .cachedIn(viewModelScope)

    val popularMovies: Flow<PagingData<Movie>> =
        allPagingMoviesUseCase.invoke(Constants.MoviesIdentifier.POPULAR)
            .cachedIn(viewModelScope)

    val topRatedMovies: Flow<PagingData<Movie>> =
        allPagingMoviesUseCase.invoke(Constants.MoviesIdentifier.TOP_RATED)
            .cachedIn(viewModelScope)

    val upcomingMovies: Flow<PagingData<Movie>> =
        allPagingMoviesUseCase.invoke(Constants.MoviesIdentifier.UPCOMING)
            .cachedIn(viewModelScope)
}