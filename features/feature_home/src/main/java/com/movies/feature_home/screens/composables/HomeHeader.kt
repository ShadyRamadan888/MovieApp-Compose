package com.movies.feature_home.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movies.design_core.R
import com.movies.design_core.components.texts.RaggaeText

@Composable
fun HomeHeader() {
    Column {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(50.dp)
        )
        RaggaeText(stringResource(R.string.choose_the_best))
    }
}

@Preview
@Composable
fun HomeHeaderPreview() {
    HomeHeader()
}