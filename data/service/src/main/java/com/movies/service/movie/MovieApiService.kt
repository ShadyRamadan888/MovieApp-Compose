package com.movies.service.movie

import com.movies.model.movie.MovieResponse
import com.movies.service.Constants
import com.movies.service.fetch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import java.net.URI

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

    suspend fun getAllPopularMovies(
        apiKey: String,
        page: Int = 1,
        category: String
    ): com.movies.service.Result<MovieResponse> {
        return client.fetch<MovieResponse> {
            url(buildUrl(apiKey, page, category))
            method = HttpMethod.Get
        }
    }

    private fun buildUrl(apiKey: String, page: Int, category: String): String {
        return URI("${Constants.BASE_URL}/movie/$category")
            .resolve("?page=$page&api_key=$apiKey")
            .toString()
    }
}

