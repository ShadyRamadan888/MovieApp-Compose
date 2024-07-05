package com.movies.model.base

sealed class SectionUiState {
    data class Success<T>(val data: T?) : SectionUiState()
    data class Error(val t: Throwable) : SectionUiState()
    object Loading : SectionUiState()
}