package com.kls.slasher.di

import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.dsl.module
import com.kls.slasher.viewmodel.HomeViewModel
import com.kls.slasher.viewmodel.MovieDetailsViewModel

val provideviewModelModule = module {
    single {
        HomeViewModel(get())
    }
    single {
        MovieDetailsViewModel(get())
    }
}