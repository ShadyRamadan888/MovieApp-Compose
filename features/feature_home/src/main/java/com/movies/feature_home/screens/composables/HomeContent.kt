package com.movies.feature_home.screens.composables

import com.movies.design_core.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.movies.design_core.components.sections.NowPlayingHorizontalSection
import com.movies.design_core.components.sections.PopularMovieHorizontalSection
import com.movies.design_core.components.sections.TopRatedMovieHorizontalSection
import com.movies.design_core.components.sections.UpcomingMovieHorizontalSection
import com.movies.design_core.components.tamplate.RowWithCategoryAndSeeAll
import com.movies.feature_home.navigation.HomeEffect
import com.movies.model.base.SectionUiState

@Composable
fun HomeContent(
    loadTopRatedMoviesUiState: SectionUiState,
    loadPopularMoviesUiState: SectionUiState,
    loadNowPlayingMoviesUiState: SectionUiState,
    loadUpcomingMoviesUiState: SectionUiState,
    onSeeAllClicked: (movieCategory: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background),
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        HomeHeader()

        Spacer(modifier = Modifier.height(40.dp))

        HomeBody(
            loadTopRatedMoviesUiState = loadTopRatedMoviesUiState,
            loadPopularMoviesUiState = loadPopularMoviesUiState,
            loadNowPlayingMoviesUiState = loadNowPlayingMoviesUiState,
            loadUpcomingMoviesUiState = loadUpcomingMoviesUiState,
            onSeeAllClicked = onSeeAllClicked,
        )
    }
}

@Composable
fun HomeBody(
    loadPopularMoviesUiState: SectionUiState,
    loadTopRatedMoviesUiState: SectionUiState,
    loadNowPlayingMoviesUiState: SectionUiState,
    loadUpcomingMoviesUiState: SectionUiState,
    onSeeAllClicked: (movieCategory: String) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        RowWithCategoryAndSeeAll(
            categoryName = stringResource(R.string.now_playing),
            onSeeAllClicked = onSeeAllClicked,
        )

        Spacer(Modifier.height(5.dp))

        NowPlayingHorizontalSection(loadNowPlayingMoviesUiState)

        Spacer(Modifier.height(20.dp))

        RowWithCategoryAndSeeAll(
            categoryName = stringResource(R.string.popular),
            onSeeAllClicked = onSeeAllClicked,
        )

        Spacer(Modifier.height(5.dp))


        PopularMovieHorizontalSection(
            loadPopularMoviesUiState = loadPopularMoviesUiState
        )
        Spacer(Modifier.height(20.dp))

        RowWithCategoryAndSeeAll(
            categoryName = stringResource(R.string.top_rated),
            onSeeAllClicked = onSeeAllClicked,
        )

        Spacer(Modifier.height(5.dp))


        TopRatedMovieHorizontalSection(
            loadTopRatedMoviesUiState = loadTopRatedMoviesUiState
        )

        Spacer(Modifier.height(20.dp))

        RowWithCategoryAndSeeAll(
            categoryName = stringResource(R.string.upcoming),
            onSeeAllClicked = onSeeAllClicked,
        )
        Spacer(Modifier.height(5.dp))

        UpcomingMovieHorizontalSection(
            loadUpcomingMoviesUiState = loadUpcomingMoviesUiState
        )

        Spacer(Modifier.height(5.dp))
    }
}