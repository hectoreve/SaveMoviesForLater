package com.example.savemoviesforlater.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.savemoviesforlater.model.Movie

@Database(
    entities = [Movie::class],
    version = 1, exportSchema = false
)
abstract class SaveMoviesDatabase : RoomDatabase() {
    abstract val moviesDao: MoviesDao
}