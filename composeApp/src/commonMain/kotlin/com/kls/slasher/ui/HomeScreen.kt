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
import app.cash.paging.compose.collectAsLazyPagingItems
import co.touchlab.kermit.Logger
import org.koin.compose.getKoin
import com.kls.slasher.viewmodel.HomeViewModel
import com.kls.slasher.ui.theme.SlasherFontFamily

@Composable
fun HomeScreen() {
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
        PagingGrid(data = lazyPagingItems, content = { MovieCard(it) })
    }
}







