package com.movies.service.factories

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.movies.model.movie.Movie
import com.movies.model.movie.MovieResponse
import com.movies.service.Result
import com.movies.service.map
import com.movies.service.movie.MovieApiService

open class MoviePagingSource(
    private val apiService: MovieApiService,
    private val apiKey: String,
    private val category: String
) :
    PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1

        return try {
            val result: Result<MovieResponse> = apiService.getAllPopularMovies(apiKey, page, category)

            // Handle the result and transform it to LoadResult.Page or LoadResult.Error
            when (result) {
                is Result.Success -> {
                    val response = result.value
                    LoadResult.Page(
                        data = response.listOfMovies,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (page == response.totalPages) null else page + 1
                    )
                }
                is Result.Error -> {
                    LoadResult.Error(result.throwable)
                }
                is Result.Loading -> {
                    // Return an empty LoadResult.Page if still loading
                    LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

