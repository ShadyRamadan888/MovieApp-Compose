package com.movies.now_playing_usecase

import androidx.paging.PagingData
import com.movies.model.movie.Movie
import com.movies.repo.movies.MoviesRepo
import kotlinx.coroutines.flow.Flow

class NowPlayingMoviesUseCase(
    private val moviesRepo: MoviesRepo
) : INowPlayingMoviesUseCase {
    override fun invoke(moviesCategory: String): Flow<List<Movie>> =
        moviesRepo.getMoviesWithCategoryUrl(moviesCategory)

    override fun getPagingNowPlayingMovies(category: String): Flow<PagingData<Movie>> =
        moviesRepo.getPagingMoviesByCategory(category)
}