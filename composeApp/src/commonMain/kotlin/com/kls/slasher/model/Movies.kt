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

@Serializable
data class Details(
    @SerialName("adult")
    val adult: Boolean = false,
    @SerialName("backdrop_path")
    val backdropPath: String? = null,
    @SerialName("belongs_to_collection")
    val belongsToCollection: CollectionInfo? = null,
    @SerialName("budget")
    val budget: Int = 0,
    @SerialName("genres")
    val genres: List<Genre> = emptyList(),
    @SerialName("homepage")
    val homepage: String? = null,
    @SerialName("id")
    val id: Int = 0,
    @SerialName("imdb_id")
    val imdbId: String? = null,
    @SerialName("origin_country")
    val originCountry: List<String> = emptyList(),
    @SerialName("original_language")
    val originalLanguage: String = "",
    @SerialName("original_title")
    val originalTitle: String = "",
    @SerialName("overview")
    val overview: String? = null,
    @SerialName("popularity")
    val popularity: Double = 0.0,
    @SerialName("poster_path")
    val posterPath: String? = null,
    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany> = emptyList(),
    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry> = emptyList(),
    @SerialName("release_date")
    val releaseDate: String = "",
    @SerialName("revenue")
    val revenue: Int = 0,
    @SerialName("runtime")
    val runtime: Int? = null,
    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage> = emptyList(),
    @SerialName("status")
    val status: String = "",
    @SerialName("tagline")
    val tagline: String? = null,
    @SerialName("title")
    val title: String = "",
    @SerialName("video")
    val video: Boolean = false,
    @SerialName("vote_average")
    val voteAverage: Double = 0.0,
    @SerialName("vote_count")
    val voteCount: Int = 0
)

@Serializable
data class CollectionInfo(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("poster_path")
    val posterPath: String? = null,
    @SerialName("backdrop_path")
    val backdropPath: String? = null
)

@Serializable
data class Genre(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("name")
    val name: String = ""
)

@Serializable
data class ProductionCompany(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("logo_path")
    val logoPath: String? = null,
    @SerialName("name")
    val name: String = "",
    @SerialName("origin_country")
    val originCountry: String? = null
)

@Serializable
data class ProductionCountry(
    @SerialName("iso_3166_1")
    val iso31661: String = "",
    @SerialName("name")
    val name: String = ""
)

@Serializable
data class SpokenLanguage(
    @SerialName("english_name")
    val englishName: String = "",
    @SerialName("iso_639_1")
    val iso6391: String = "",
    @SerialName("name")
    val name: String = ""
)

