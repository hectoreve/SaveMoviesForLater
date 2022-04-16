package com.example.savemoviesforlater.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @NonNull
    @PrimaryKey
    val id: Int,
    val overview: String,
    val releaseDate: String,
    val title: String,
    val genre_ids: List<Int>,
    val originalTitle: String,
    val posterPath: String,
    val popularity: Double,
    val mediaType: String
)