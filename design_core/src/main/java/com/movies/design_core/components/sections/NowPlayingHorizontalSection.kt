package com.movies.design_core.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.movies.design_core.components.cards.CardWithBackgroundWideImage
import com.movies.design_core.components.items.TallMovieImageItem
import com.movies.design_core.components.progress_bars.CircularIndeterminateProgressBar
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie

@Composable
fun NowPlayingHorizontalSection(
    loadNowPlayingUiState: SectionUiState
) {

    var nowPlayingList by remember { mutableStateOf(emptyList<Movie>()) }
    var isNowPlayingLoading by remember { mutableStateOf(true) }

    when (loadNowPlayingUiState) {
        is SectionUiState.Loading -> {
            isNowPlayingLoading = true
        }

        is SectionUiState.Success<*> -> {
            isNowPlayingLoading = false
            nowPlayingList = loadNowPlayingUiState.data as List<Movie> ?: emptyList()
        }

        is SectionUiState.Error -> {
            isNowPlayingLoading = true
        }
    }

    if (isNowPlayingLoading) {
        CircularIndeterminateProgressBar(true)
    } else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
            )
        ) {
            items(nowPlayingList) { item ->
                CardWithBackgroundWideImage(
                    item
                )
            }
        }
    }

}