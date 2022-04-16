package com.example.savemoviesforlater.ui.tmdblist

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savemoviesforlater.data.repository.MovieRepository
import com.example.savemoviesforlater.model.AppResult
import com.example.savemoviesforlater.model.Event
import com.example.savemoviesforlater.model.Movie
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListingViewModel(private val repository: MovieRepository) : ViewModel() {
    val showLoading = ObservableBoolean()
    val movieList = MutableLiveData<List<Movie>>()
    private val statusMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
        get() = statusMessage

    fun getAllMovies() {
        viewModelScope.launch {
            repository.getPopularMoviesApi().collect { result ->
                when (result?.status) {
                    AppResult.Status.ERROR -> statusMessage.value = Event("ERROR: ${result.error} \n ${result.message}")
                    AppResult.Status.SUCCESS -> movieList.value = result.data!!.movies!!
                    AppResult.Status.LOADING -> showLoading.set(true)
                }
            }
            showLoading.set(false)
        }
    }
}