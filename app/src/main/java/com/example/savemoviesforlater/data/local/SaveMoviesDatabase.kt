package com.example.savemoviesforlater.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.savemoviesforlater.data.GenreConverters
import com.example.savemoviesforlater.model.Movie

@Database(
    entities = [Movie::class],
    version = 1, exportSchema = false
)
@TypeConverters(GenreConverters::class)
abstract class SaveMoviesDatabase : RoomDatabase() {
    abstract val moviesDao: MoviesDao
}