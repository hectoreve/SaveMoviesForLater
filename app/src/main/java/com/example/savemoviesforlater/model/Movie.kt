package com.example.savemoviesforlater.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
data class Movie(
    @PrimaryKey
    @Json(name = "id") val id: Int,
    @Json(name = "overview") val overview: String,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "backdrop_path") val backdropPath: String,
    @Json(name = "title") val title: String,
    @Json(name = "genre_ids") val genre_ids: List<Int>,
    @Json(name = "original_title") val originalTitle: String,
    @Json(name = "poster_path") val posterPath: String,
    @Json(name = "popularity") val popularity: Double,
    @Json(name = "media_type") val mediaType: String
)