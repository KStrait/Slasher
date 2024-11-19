package com.kls.slasher.viewmodel

import com.kls.slasher.network.MovieRepository
import org.koin.core.module.Module

class HomeViewModel(private val movieRepository: MovieRepository) {

    val movies = movieRepository.getMovies()
}