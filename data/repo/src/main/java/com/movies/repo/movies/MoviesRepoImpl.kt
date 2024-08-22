package com.movies.repo.movies

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.movies.model.movie.Movie
import com.movies.service.BuildConfig
import com.movies.service.factories.MoviePagingSource
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
    }

    override fun getPagingMoviesByCategory(category: String): Flow<PagingData<Movie>> {

        val pager = Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                MoviePagingSource(
                    movieApiService,
                    BuildConfig.API_KEY,
                    category
                )
            }
        )
        return pager.flow
    }
}