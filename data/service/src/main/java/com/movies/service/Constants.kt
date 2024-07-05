package com.movies.service

object Constants {
    const val BASE_URL = BuildConfig.BASE_URL
    const val API_KEY = BuildConfig.API_KEY

    object MoviesEndpoints {
        const val NOW_PLAYING = "$BASE_URL/movie/now_playing?api_key=$API_KEY"
        const val POPULAR = "$BASE_URL/movie/popular?api_key=$API_KEY"
        const val TOP_RATED = "$BASE_URL/movie/top_rated?api_key=$API_KEY"
        const val UPCOMING = "$BASE_URL/movie/upcoming?api_key=$API_KEY"
    }
    object MoviesIdentifier{
        const val NOW_PLAYING = "now_playing"
        const val POPULAR = "popular"
        const val TOP_RATED = "top_rated"
        const val UPCOMING = "upcoming"
    }

}