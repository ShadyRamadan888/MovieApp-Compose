package com.movies.repo.movies

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.movies.model.movie.Movie
import com.movies.service.factories.ResultPagingSource
import com.movies.service.map
import com.movies.service.movie.MovieApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesRepoImpl(
    private val movieApiService: MovieApiService
) : MoviesRepo {
    override fun getMoviesWithCategoryUrl(categoryUrl: String): Flow<List<Movie>> = flow {
        val response = movieApiService
            .getMoviesByCategory(categoryUrl)
            .listOfMovies
        emit(response)
        Log.v("testRepo",response.toString())
    }

    override fun streamMovies(): Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 10,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            ResultPagingSource { page, _ ->
                movieApiService.getAllPopularMovies(page)
                    .map { result ->
                        result.listOfMovies.ifEmpty {
                            listOf(
                                Movie(
                                    title = "Mock Title"
                                )
                            )
                        }
                    }
            }
        }
    ).flow

}