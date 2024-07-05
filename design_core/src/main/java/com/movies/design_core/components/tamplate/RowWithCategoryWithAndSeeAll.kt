package com.movies.design_core.components.tamplate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.movies.design_core.R
import com.movies.design_core.components.texts.RegularText
import com.movies.design_core.ui.theme.GrayText
import com.movies.service.Constants
import java.util.Locale


@Composable
fun RowWithCategoryAndSeeAll(
    categoryName: String,
    onSeeAllClicked: (movieCategory: String) -> Unit,
) {
    Spacer(Modifier.height(5.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(85f),
        ) {
            RegularText(
                text = categoryName,
                fontSize = 17.sp,
            )
        }
        Box(
            modifier = Modifier
                .weight(15f)
                .align(Alignment.CenterVertically)
        ) {
            ClickableText(
                text = AnnotatedString("See All"),
                onClick = {
                    when (categoryName) {
                        "Popular" -> onSeeAllClicked(Constants.MoviesIdentifier.POPULAR)
                        "Top Rated" -> onSeeAllClicked(Constants.MoviesIdentifier.TOP_RATED)
                        "Upcoming" -> onSeeAllClicked(Constants.MoviesIdentifier.UPCOMING)
                        "Now Playing" -> onSeeAllClicked(Constants.MoviesIdentifier.NOW_PLAYING)
                        else -> onSeeAllClicked(Constants.MoviesIdentifier.NOW_PLAYING)
                    }
                },
                style = TextStyle(
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}