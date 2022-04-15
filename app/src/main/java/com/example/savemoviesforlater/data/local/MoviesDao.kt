package com.example.savemoviesforlater.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.savemoviesforlater.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesDao {
    @Query("SELECT * FROM movie order by popularity DESC")
    fun getAll(): Flow<List<Movie>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Movie>)

    @Delete
    fun delete(movie: Movie)

    @Delete
    fun deleteAll(movie: List<Movie>)
}