package com.movies.service.movie

import com.movies.model.movie.Movie
import com.movies.model.movie.MovieResponse
import com.movies.service.Constants
import com.movies.service.fetch
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json
import io.ktor.client.request.url

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

    suspend fun getAllPopularMovies(page: Int = 1) =
        client.fetch<MovieResponse> {
            url("https://api.themoviedb.org/3/movie/popular?page=$page&api_key=e0bd6b7b07bcd271f8b131a201f58222")
            method = HttpMethod.Get
        }
}

