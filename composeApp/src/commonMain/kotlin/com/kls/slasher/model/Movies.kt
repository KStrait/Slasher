package com.kls.slasher.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("page")
    var page: Int = 0,
    @SerialName("results")
    var movies: List<Movies> = emptyList(),
    @SerialName("total_pages")
    var total_pages: Int = 0,
    @SerialName("total_results")
    var total_results: Int = 0
)

@Serializable
data class Movies(
    @SerialName("adult")
    var adult: Boolean = false,
    @SerialName("backdrop_path")
    var backdrop_path: String? = null,
    @SerialName("genre_ids")
    var genre_ids: List<Int> = emptyList(),
    @SerialName("id")
    var id: Int = 0,
    @SerialName("original_language")
    var original_language: String = "",
    @SerialName("original_title")
    var original_title: String = "",
    @SerialName("overview")
    var overview: String = "",
    @SerialName("popularity")
    var popularity: Double = 0.0,
    @SerialName("poster_path")
    var poster_path: String = "",
    @SerialName("release_date")
    var release_date: String = "",
    @SerialName("title")
    var title: String = "",
    @SerialName("video")
    var video: Boolean = false,
    @SerialName("vote_average")
    var vote_average: Double = 0.0,
    @SerialName("vote_count")
    var vote_count: Double = 0.0,
    @SerialName("name")
    var name: String = ""
)

