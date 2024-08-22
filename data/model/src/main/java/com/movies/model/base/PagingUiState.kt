package com.movies.model.base


sealed class PagingUiState {
    data class Success<out T>(val data: T?) : PagingUiState()
    data class Error(val t: Throwable) : PagingUiState()
    object Loading : PagingUiState()
}