package com.kls.slasher.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kls.slasher.model.Details
import com.kls.slasher.model.Movies
import com.kls.slasher.network.ApiService.getMovieDetails
import com.kls.slasher.network.ApiService.getMovies
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository(private val httpClient: HttpClient) {
    fun getMovies(): Flow<PagingData<Movies>> = Pager(
        config = PagingConfig(pageSize = 1, initialLoadSize = 1, enablePlaceholders = false,),
        pagingSourceFactory = {
            ResultPagingSource { page, _ ->
                delay(800)
                httpClient.getMovies(page).map { it.movies }
            }
        }
    ).flow

    fun getMovieDetailsFlow(id: String): Flow<Result<Details>> = flow {
        val movieDetails = httpClient.getMovieDetails(id) // Call the suspend function
        emit(movieDetails) // Emit the result
    }
}