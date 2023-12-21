package com.movies.service

object Constants {
    private const val BASE_URL = BuildConfig.BASE_URL
    const val API_KEY = BuildConfig.API_KEY

    object MOVIES {
        const val POPULAR = "$BASE_URL/movie/popular?api_key=$API_KEY"
        const val TOP_RATED = "$BASE_URL/movie/top_rated?api_key=$API_KEY"
        const val UPCOMING = "$BASE_URL/movie/upcoming?api_key=$API_KEY"
    }
}