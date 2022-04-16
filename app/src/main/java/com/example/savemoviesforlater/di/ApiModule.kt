package com.example.savemoviesforlater.di

import com.example.savemoviesforlater.network.service.MoviesApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
    single { provideMoviesApi(get()) }

}