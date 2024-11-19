package com.kls.slasher.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import app.cash.paging.compose.collectAsLazyPagingItems
import org.koin.compose.getKoin
import com.kls.slasher.viewmodel.HomeViewModel
import com.kls.slasher.model.Movies

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = getKoin().get()
    val lazyPagingItems by rememberUpdatedState(viewModel.movies.collectAsLazyPagingItems())

    LazyColumn {
        println("ITEMS: ${lazyPagingItems.itemCount}")
        items(lazyPagingItems.itemCount) { mov ->
            val item = lazyPagingItems[mov]
            item?.let {
                println(it.title)
                Text(text = it.title)
            }
        }
    }
}