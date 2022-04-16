package com.example.savemoviesforlater.model

import com.squareup.moshi.Json

data class MovieDesc(
    @Json(name = "id") val id: Int,
    @Json(name = "overview") val overview: String,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "title") val title: String,
    @Json(name = "genre_ids") val genre_ids: List<GenreSingle>,
    @Json(name = "original_title") val originalTitle: String,
    @Json(name = "poster_path") val posterPath: String,
    @Json(name = "popularity") val popularity: Double,
)

data class GenreSingle(val id: Int, val name: String)