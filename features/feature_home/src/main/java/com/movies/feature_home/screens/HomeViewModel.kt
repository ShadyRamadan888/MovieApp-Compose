package com.movies.feature_home.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.model.base.RetryTrigger
import com.movies.model.base.SectionUiState
import com.movies.model.base.retryableFlow
import com.movies.movies_usecase.IPopularMoviesUseCase
import com.movies.service.Constants
import com.movies.top_rated_movies_usecase.ITopRatedMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val popularMoviesUseCase: IPopularMoviesUseCase,
    private val topRatedMoviesUseCase: ITopRatedMoviesUseCase
) : ViewModel() {

    private val popularMoviesRetryTrigger = RetryTrigger()
    private val topRatedMoviesRetryTrigger = RetryTrigger()

    val loadPopularMoviesUiState: StateFlow<SectionUiState> = loadPopularMovie()

    private fun loadPopularMovie(): StateFlow<SectionUiState> {
        return launchStateFlow(
            flow = popularMoviesUseCase(Constants.MOVIES.POPULAR).map { movies ->
                SectionUiState.Success(movies)
            },
            retryTrigger = popularMoviesRetryTrigger,
            initialState = SectionUiState.Loading,
            errorState = { SectionUiState.Error(it) }
        )
    }

    val loadTopRatedMoviesUiState: StateFlow<SectionUiState> = topRatedPopularMovie()

    private fun topRatedPopularMovie(): StateFlow<SectionUiState> {
        return launchStateFlow(
            flow = topRatedMoviesUseCase(Constants.MOVIES.TOP_RATED).map { movies ->
                SectionUiState.Success(movies)
            },
            retryTrigger = topRatedMoviesRetryTrigger,
            initialState = SectionUiState.Loading,
            errorState = { SectionUiState.Error(it) }
        )
    }



    protected fun <T> launchStateFlow(
        flow: Flow<T>,
        retryTrigger: RetryTrigger,
        errorState: (Throwable) -> T,
        initialState: T
    ): StateFlow<T> {
        return retryableFlow(retryTrigger) {
            flow.onStart { emit(initialState) }.catch {
                emit(errorState(it))
            }
        }.flowOn(Dispatchers.IO).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = initialState
        )
    }

}