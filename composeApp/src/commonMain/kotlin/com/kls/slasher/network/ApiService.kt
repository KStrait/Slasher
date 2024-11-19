package com.kls.slasher.network

import com.kls.slasher.model.ApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.HttpMethod

object ApiService {

    suspend fun HttpClient.getMovies(page: Int = 0) =
        getResults<ApiResponse> {
            url("https://api.themoviedb.org/3/discover/movie?with_genres=27&page=${page * 10}")
            header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMGFiZDYyZWRjYjZiNTUyMWJmNDE0NjljZjM2Nzk3YiIsInN1YiI6IjVjNGY1ZDQ2YzNhMzY4NzRiOTgxYTAwNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.jbC_5lNOAx58RGQS-f8HNWhL2Fkfq93LyizRxADvdOI")
            header("Accept", "application/json")
            method = HttpMethod.Get
        }
}