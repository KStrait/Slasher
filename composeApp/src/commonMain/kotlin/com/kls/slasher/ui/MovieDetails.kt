package com.kls.slasher.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kls.slasher.getPlatform

@Composable
fun MovieDetails(movieId: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        if (getPlatform().ios) {
            Button(onClick = {  }) {
                Text("Back")
            }
        }
        Text(modifier = Modifier.fillMaxSize(), text = "Movie ID: $movieId")
    }
}

