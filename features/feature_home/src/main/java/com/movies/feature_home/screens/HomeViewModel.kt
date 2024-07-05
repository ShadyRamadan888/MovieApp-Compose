package com.movies.feature_home.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.feature_home.navigation.HomeEffect
import com.movies.model.base.SectionUiState
import com.movies.movies_usecase.IPopularMoviesUseCase
import com.movies.now_playing_usecase.INowPlayingMoviesUseCase
import com.movies.service.Constants
import com.movies.top_rated_movies_usecase.ITopRatedMoviesUseCase
import com.movies.upcoming_usecase.IUpcomingMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(
    private val popularMoviesUseCase: IPopularMoviesUseCase,
    private val topRatedMoviesUseCase: ITopRatedMoviesUseCase,
    private val nowPlayingMoviesUseCase: INowPlayingMoviesUseCase,
    private val upcomingMoviesUseCase: IUpcomingMoviesUseCase,
) : ViewModel() {

    init {
        loadPopularMovies()
        loadTopRatedPopularMovies()
        loadNowPlayingMovies()
        loadUpcomingMovies()
    }

    private var _upcomingMoviesUiState = MutableStateFlow<SectionUiState>(SectionUiState.Loading)
    val upcomingMoviesUiState = _upcomingMoviesUiState


    private fun loadUpcomingMovies() {
        viewModelScope.launch {
            upcomingMoviesUseCase.invoke(Constants.MoviesEndpoints.UPCOMING)
                .map { SectionUiState.Success(it) }
                .catch { _upcomingMoviesUiState.value = SectionUiState.Loading }
                .collect { _upcomingMoviesUiState.value = it }
        }
    }

    private var _nowPlayingMoviesUiState = MutableStateFlow<SectionUiState>(SectionUiState.Loading)
    val nowPlayingMoviesUiState = _nowPlayingMoviesUiState


    private fun loadNowPlayingMovies() {
        viewModelScope.launch {
            nowPlayingMoviesUseCase.invoke(Constants.MoviesEndpoints.NOW_PLAYING)
                .map { SectionUiState.Success(it) }
                .catch { _nowPlayingMoviesUiState.value = SectionUiState.Loading }
                .collect { _nowPlayingMoviesUiState.value = it }
        }
    }


    private var _popularMoviesUiState = MutableStateFlow<SectionUiState>(SectionUiState.Loading)
    val popularMoviesUiState = _popularMoviesUiState


    private fun loadPopularMovies() {
        viewModelScope.launch {
            popularMoviesUseCase.invoke(Constants.MoviesEndpoints.POPULAR)
                .map { SectionUiState.Success(it) }
                .catch { _popularMoviesUiState.value = SectionUiState.Loading }
                .collect { _popularMoviesUiState.value = it }
        }
    }

    private var _topRatedMoviesUiState =
        MutableStateFlow<SectionUiState>(SectionUiState.Loading)
    val topRatedMoviesUiState = _topRatedMoviesUiState
    private fun loadTopRatedPopularMovies() {
        viewModelScope.launch {
            topRatedMoviesUseCase.invoke(Constants.MoviesEndpoints.TOP_RATED)
                .map { SectionUiState.Success(it) }
                .catch { _topRatedMoviesUiState.value = SectionUiState.Loading }
                .collect { _topRatedMoviesUiState.value = it }
        }
    }

}