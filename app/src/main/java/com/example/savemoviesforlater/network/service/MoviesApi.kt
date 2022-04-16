package com.example.savemoviesforlater.network.service

import com.example.savemoviesforlater.model.AppResult
import com.example.savemoviesforlater.model.Movie
import com.example.savemoviesforlater.model.TrendingMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {
    @GET("/3/trending/movie/week")
    suspend fun getPopularMovies() : AppResult<TrendingMovieResponse>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int) : AppResult<Movie>
}