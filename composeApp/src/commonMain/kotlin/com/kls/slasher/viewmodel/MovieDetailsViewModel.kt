package com.kls.slasher.viewmodel

import androidx.lifecycle.ViewModel
import com.kls.slasher.network.MovieRepository

class MovieDetailsViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun moviesDetails(id: String) = movieRepository.getMovieDetailsFlow(id)

}