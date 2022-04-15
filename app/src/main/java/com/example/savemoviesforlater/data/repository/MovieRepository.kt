package com.example.savemoviesforlater.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.savemoviesforlater.model.Movie
import com.example.savemoviesforlater.model.TrendingMovieResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieRepository {
    fun getAll(): Flow<List<Movie>?>
    fun insertAll(movies: List<Movie>)
    fun delete(movie: Movie)
    fun deleteAll(movie: List<Movie>)
    suspend fun getPopularMovies() : Response<TrendingMovieResponse>
    suspend fun getMovie(@Path("movie_id") id: Int) : Response<Movie>
}