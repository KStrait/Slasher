package com.kls.slasher.di

import org.koin.dsl.module
import com.kls.slasher.viewmodel.HomeViewModel

val provideviewModelModule = module {
    single {
        HomeViewModel(get())
    }
}