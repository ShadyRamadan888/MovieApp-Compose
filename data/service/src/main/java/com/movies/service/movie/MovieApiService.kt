package com.movies.service.movie

import com.movies.model.movie.MovieResponse
import com.movies.service.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class MovieApiService(private val client: HttpClient) {

    private val json = Json { ignoreUnknownKeys = true }

    //Category like: Popular, top rated, upcoming .. etc
    suspend fun getMoviesByCategory(categoryUrl: String): MovieResponse {
        val httpResponse = client.get(categoryUrl) {
            headers {
                append(HttpHeaders.Authorization, "Bearer ${Constants.API_KEY}")
            }
        }
        return json.decodeFromString(
            (MovieResponse.serializer()),
            httpResponse.bodyAsText()
        )
    }
}
