package com.movies.feature_all_movies.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.all_movies_usecase.IPagingMoviesUseCase
import com.movies.model.base.PagingUiState
import com.movies.model.movie.Movie
import com.movies.service.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AllMoviesViewModel(
    private val allPagingMoviesUseCase: IPagingMoviesUseCase
) : ViewModel() {


    private val _pagingMoviesUiState =
        MutableStateFlow<PagingUiState>(PagingUiState.Loading)
    val pagingMoviesUiState: StateFlow<PagingUiState> =
        _pagingMoviesUiState


    fun loadPagingMovies(category: String) {
        viewModelScope.launch {
            try {
                val pagingDataFlow: Flow<PagingData<Movie>> =
                    allPagingMoviesUseCase.invoke(category)
                _pagingMoviesUiState.value = PagingUiState.Success(pagingDataFlow)
                Log.v("SHR", "Success")
            } catch (e: Exception) {
                _pagingMoviesUiState.value = PagingUiState.Error(e)
                Log.v("SHR", "Exception: ${e.message}")
            }
        }
    }

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