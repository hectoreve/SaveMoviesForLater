package com.example.savemoviesforlater

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.core.context.startKoin

class SaveMoviesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        startKoin{

        }

    }
}