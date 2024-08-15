package com.movies.feature_home.navigation


sealed class HomeEvent {
    object LoadHome : HomeEvent()
    data class NavigateTo(val destination: HomeEffect.HomeNavigation) : HomeEvent()
}

sealed class HomeEffect {

    data class ShowError(val throwable: Throwable?) : HomeEffect()
    sealed class HomeNavigation : HomeEffect() {
        object ToNowPlayingMovies : HomeNavigation()
        object ToUpcomingMovies : HomeNavigation()
        object ToTopRatedMovies : HomeNavigation()
        object ToPopularMovies : HomeNavigation()
    }
}