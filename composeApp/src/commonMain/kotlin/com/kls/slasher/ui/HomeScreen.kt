package com.kls.slasher.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.cash.paging.compose.collectAsLazyPagingItems
import co.touchlab.kermit.Logger
import com.kls.slasher.model.Movies
import org.koin.compose.getKoin
import com.kls.slasher.viewmodel.HomeViewModel
import com.kls.slasher.ui.theme.SlasherFontFamily
import org.jetbrains.compose.resources.StringResource
import slasher.composeapp.generated.resources.Res
import slasher.composeapp.generated.resources.home
import slasher.composeapp.generated.resources.movie_details

/**
 * enum values that represent the screens in the app
 */
enum class AppScreen(val route: String) {
    Home(route = "home"),
    MovieDetails(
        route = "movie_details/{movieId}"
    )
}

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.name,
    ) {
        composable(route = AppScreen.Home.name) {
            MoviesList(navController)
        }
        composable(
            route = AppScreen.MovieDetails.route,
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            MovieDetails(movieId ?: "")
        }
    }
}

@Composable
fun MoviesList(
    navController: NavHostController
) {
    val viewModel: HomeViewModel = getKoin().get()
    val lazyPagingItems by rememberUpdatedState(viewModel.movies.collectAsLazyPagingItems())

    // Main content container (Column)
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(WindowInsets.systemBars.only(WindowInsetsSides.Top).asPaddingValues()) // Optional: custom padding
            .consumeWindowInsets(WindowInsets.statusBars),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        // Custom top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)  // Set the height of the top bar
                .background(Color.Red),
            verticalAlignment = Alignment.CenterVertically,  // Vertically center the content in the row
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "SLASHER",
                modifier = Modifier.padding(top = 9.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = SlasherFontFamily()
            )
        }

        // Content below the app bar
        PagingGrid(data = lazyPagingItems, content = { MovieCard(it, navController) })
    }
}