package com.movies.design_core.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.movies.design_core.R
import com.movies.design_core.components.texts.RegularText
import com.movies.model.base.SectionUiState
import com.movies.model.movie.Movie

@Composable
fun CardWithBackgroundWideImage(
    movie: Movie = Movie()
) {

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
    ) {

        ConstraintLayout(modifier = Modifier.wrapContentSize()) {

            val (backImage, poster, textColumn) = createRefs()

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500\\" + movie.backdropPath,
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backImage) {

                    }
                    .size(width = 300.dp, height = 180.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.placeholder_image)
            )
            Card(
                Modifier
                    .constrainAs(poster) {
                        start.linkTo(backImage.start, 5.dp)
                        bottom.linkTo(backImage.bottom, 5.dp)
                    }
                    .clip(RoundedCornerShape(8.dp))
            ) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500\\" + movie.posterPath,
                    contentDescription = null,
                    modifier = Modifier
                        .width(85.dp)
                        .height(110.dp),
                    contentScale = ContentScale.FillBounds,
                    placeholder = painterResource(R.drawable.placeholder_image)
                )
            }
            Column(
                Modifier.constrainAs(textColumn) {
                    start.linkTo(poster.end)
                    bottom.linkTo(backImage.bottom)
                }
                    .width(210.dp)
                    .padding(8.dp)
            ) {
                RegularText(
                    fontSize = 12.sp,
                    text = requireNotNull(movie.title),
                    color = Color.White
                )
                Spacer(Modifier.height(2.dp))
                RegularText(
                    fontSize = 10.sp,
                    text = requireNotNull(movie.overview),
                    color = Color.White
                )
            }

        }
    }
}

@Composable
@Preview
fun CardWithBackgroundImagePreview() {
    CardWithBackgroundWideImage()
}