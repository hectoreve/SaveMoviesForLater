package com.example.savemoviesforlater.data.local

import androidx.room.*
import com.example.savemoviesforlater.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movie order by popularity DESC")
    fun getAll(): List<Movie>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Movie>)

    @Delete
    fun delete(movie: Movie)

    @Delete
    fun deleteAll(movie: List<Movie>)
}