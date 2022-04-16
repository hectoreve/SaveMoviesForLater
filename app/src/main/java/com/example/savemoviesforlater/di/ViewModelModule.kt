package com.example.savemoviesforlater.di

import com.example.savemoviesforlater.ui.tmdblist.ListingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build CountriesViewModel
    viewModel {
        ListingViewModel(repository = get())
    }

}