package com.example.cleanarchitecture.di

import android.app.Application

class App : Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        appContainer = AppContainer(this)
        super.onCreate()
    }
}