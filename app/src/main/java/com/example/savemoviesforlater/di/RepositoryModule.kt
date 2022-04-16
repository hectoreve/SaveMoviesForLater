package com.example.savemoviesforlater.di

import android.content.Context
import com.example.savemoviesforlater.data.local.MoviesDao
import com.example.savemoviesforlater.data.repository.MovieRepository
import com.example.savemoviesforlater.data.repository.MovieRepositoryImp
import com.example.savemoviesforlater.network.service.MoviesApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideMovieRepository(api: MoviesApi, context: Context, dao : MoviesDao): MovieRepository {
        return MovieRepositoryImp(api, context, dao)
    }
    single { provideMovieRepository(get(), androidContext(), get()) }

}