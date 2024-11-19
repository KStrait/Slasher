package com.kls.slasher.di

import org.koin.dsl.module
import com.kls.slasher.network.MovieRepository

val provideRepositoryModule = module {
    single<MovieRepository> { MovieRepository(get()) }
}