package com.kls.slasher.viewmodel

import androidx.lifecycle.ViewModel
import com.kls.slasher.network.MovieRepository
import org.koin.core.module.Module

class HomeViewModel(private val movieRepository: MovieRepository): ViewModel() {

    val movies = movieRepository.getMovies()
}