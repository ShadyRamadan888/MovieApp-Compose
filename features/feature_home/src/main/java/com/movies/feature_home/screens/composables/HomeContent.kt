package com.movies.feature_home.screens.composables

import com.movies.design_core.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.movies.design_core.components.BasicBrush
import com.movies.design_core.components.cards.CardWithBackgroundWideImage
import com.movies.design_core.components.sections.PopularMovieHorizontalSection
import com.movies.design_core.components.sections.TopRatedMovieHorizontalSection
import com.movies.design_core.components.tamplate.RowWithCategoryAndSeeAll
import com.movies.model.base.SectionUiState

@Composable
fun HomeContent(
    loadTopRatedMoviesUiState: SectionUiState,
    loadPopularMoviesUiState: SectionUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(BasicBrush),
    ) {
        HomeHeader()

        Spacer(modifier = Modifier.height(50.dp))

        HomeBody(
            loadTopRatedMoviesUiState,
            loadPopularMoviesUiState,
        )
    }
}

@Composable
fun HomeBody(
    loadPopularMoviesUiState: SectionUiState,
    loadTopRatedMoviesUiState: SectionUiState,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CardWithBackgroundWideImage()

        Spacer(Modifier.height(20.dp))

        RowWithCategoryAndSeeAll(categoryName = stringResource(R.string.popular))

        Spacer(Modifier.height(20.dp))

        PopularMovieHorizontalSection(
            loadPopularMoviesUiState = loadPopularMoviesUiState
        )

        RowWithCategoryAndSeeAll(categoryName = stringResource(R.string.top_rated))

        Spacer(Modifier.height(20.dp))

        TopRatedMovieHorizontalSection(
            loadTopRatedMoviesUiState = loadTopRatedMoviesUiState
        )
    }
}