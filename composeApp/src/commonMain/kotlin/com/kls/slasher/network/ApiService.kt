package com.kls.slasher.network

import com.kls.slasher.BuildKonfig
import com.kls.slasher.model.ApiResponse
import com.kls.slasher.model.Details
import io.ktor.client.HttpClient
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.HttpMethod

object ApiService {

    suspend fun HttpClient.getMovies(page: Int = 0) =
        getResults<ApiResponse> {
            url("https://api.themoviedb.org/3/discover/movie?with_genres=27&page=$page")
            header("Authorization", BuildKonfig.API_KEY)
            header("Accept", "application/json")
            method = HttpMethod.Get
        }

    suspend fun HttpClient.getMovieDetails(id: String) = getResults<Details> {
        url("https://api.themoviedb.org/3/movie/$id")
        header("Authorization", BuildKonfig.API_KEY)
        header("Accept", "application/json")
        method = HttpMethod.Get
    }
}