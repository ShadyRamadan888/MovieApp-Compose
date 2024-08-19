package com.movies.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("results")
    val listOfMovies: List<Movie> = emptyList(),
    @SerialName("page")
    val page: Int? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null,
    @SerialName("dates")
    val dates: Dates? = null
)

@Serializable
data class Dates(
    @SerialName("maximum")
    val maximum:String,
    @SerialName("minimum")
    val minimum:String
)