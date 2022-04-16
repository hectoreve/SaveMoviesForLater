package com.example.savemoviesforlater.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.savemoviesforlater.model.AppResult
import com.example.savemoviesforlater.model.Movie
import com.example.savemoviesforlater.model.TrendingMovieResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieRepository {
//    fun getAllDB(): Flow<List<Movie>?>
//    fun insertAllDB(movies: List<Movie>)
//    fun deleteDBMovie(movie: Movie)
//    fun deleteAllDB(movie: List<Movie>)
    suspend fun getPopularMoviesApi() : Flow<AppResult<TrendingMovieResponse>?>
    suspend fun getMovieApi(@Path("movie_id") id: Int) : Flow<AppResult<Movie>?>
}