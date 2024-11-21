package com.kls.slasher.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import com.kls.slasher.model.Movies


@Composable
fun MovieCard(movie: Movies, navController: NavController) {
//    MovieItem(movie.title, movie.overview, movie.poster_path)
    MovieItem2(movie.poster_path, navController)
}


@Composable
fun MovieItem(name: String, description: String, image: String) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .aspectRatio(2f / 3f),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            KamelImage(
                resource = asyncPainterResource(data = "https://image.tmdb.org/t/p/original$image"),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun MovieItem2(image: String, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth() // Full width of the parent
            .aspectRatio(2f / 3f) // 2:3 width-to-height ratio
            .clickable {
                navController.navigate("movie_details/${image.drop(1)}")
            },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = Color.Black
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                KamelImage(
                    resource = asyncPainterResource(data = "https://image.tmdb.org/t/p/original$image"),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Fit // Ensures no cropping,
                )
            }
        }
    }
}
