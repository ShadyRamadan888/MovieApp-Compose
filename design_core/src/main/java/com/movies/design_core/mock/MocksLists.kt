package com.movies.design_core.mock

import com.movies.model.movie.Movie


val mockMovie = Movie(
    backdropPath = "https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
)

fun movieItemsMock(count: Int): List<Movie> {
    val list = mutableListOf<Movie>()
    for (i in 0..count) {
        list.add(mockMovie)
    }
    return list
}