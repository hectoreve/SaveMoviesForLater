package com.example.savemoviesforlater.data.repository

import android.content.Context
import com.example.savemoviesforlater.data.local.MoviesDao
import com.example.savemoviesforlater.model.AppResult
import com.example.savemoviesforlater.model.Movie
import com.example.savemoviesforlater.model.TrendingMovieResponse
import com.example.savemoviesforlater.network.service.MoviesApi
import com.example.savemoviesforlater.util.NetworkManager.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response

class MovieRepositoryImp(
    private val api: MoviesApi,
    private val context: Context,
    private val dao: MoviesDao

) : MovieRepository {

    override suspend fun getPopularMoviesApi(): Flow<AppResult<TrendingMovieResponse>?> {
        return flow {
            emit(fetchTrendingMoviesCached())
            if (isOnline(context)) {
                emit(AppResult.loading())
                val response = api.getPopularMovies()
                if (response.status == AppResult.Status.SUCCESS) {
                    response.data?.movies?.let {
                        withContext(Dispatchers.IO) { dao.insertAll(it) }
                    }
                }
                emit(response)
            }
        }.flowOn(Dispatchers.Default)
    }

    override suspend fun getMovieApi(id: Int): Flow<AppResult<Movie>?> =
        flow<AppResult<Movie>?> {
            emit(AppResult.loading())
            emit(api.getMovie(id))
        }.flowOn(Dispatchers.IO)

    private fun fetchTrendingMoviesCached(): AppResult<TrendingMovieResponse>? =
        dao.getAll()?.let {
            return AppResult.success(TrendingMovieResponse(it))
        }

}