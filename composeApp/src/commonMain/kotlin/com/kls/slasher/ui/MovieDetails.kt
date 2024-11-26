package com.kls.slasher.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kls.slasher.getPlatform
import com.kls.slasher.network.Result
import com.kls.slasher.viewmodel.MovieDetailsViewModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun MovieDetails(movieId: String, navController: NavController, viewModel: MovieDetailsViewModel) {
    val details = viewModel.moviesDetails(movieId).collectAsState(initial = Result.Loading)

    when (val state = details.value) {
            is Result.Loading -> {
                Text(text = "Loading...")
            }

            is Result.Success -> {
                state.value.posterPath?.let {
                    DetailsColumn(imageUrl = it, navController = navController)
                }
            }

            is Result.Error -> {
                Text(text = "Error")
            }
        }
}

@Composable
fun DetailsColumn(imageUrl: String, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(WindowInsets.systemBars.only(WindowInsetsSides.Top).asPaddingValues()) // Optional: custom padding
            .consumeWindowInsets(WindowInsets.statusBars),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MoviePoster(imageUrl)
        }

        if (getPlatform().ios) {
            item {
                Button(onClick = {
                    navController.navigateUp()
                }) {
                    Text("Back")
                }
            }
        }
    }
}

@Composable
fun MoviePoster(image: String) {
    KamelImage(
        resource = asyncPainterResource(data = "https://image.tmdb.org/t/p/original$image"),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(0.5f).wrapContentHeight().padding(top = 16.dp),
        contentScale = ContentScale.Fit,
    )
}