package com.kls.slasher

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.kls.slasher.di.appModule
import com.kls.slasher.ui.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            MaterialTheme {
                HomeScreen()
            }
        }
    }
}