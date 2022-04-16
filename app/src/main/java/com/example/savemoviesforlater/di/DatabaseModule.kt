package com.example.savemoviesforlater.di

import android.app.Application
import androidx.room.Room
import com.example.savemoviesforlater.data.local.MoviesDao
import com.example.savemoviesforlater.data.local.SaveMoviesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): SaveMoviesDatabase{
        return Room.databaseBuilder(application, SaveMoviesDatabase::class.java, "countries")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideMoviesDao(database: SaveMoviesDatabase): MoviesDao {
        return  database.moviesDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideMoviesDao(get()) }


}