package com.example.cleanarchitecture.di

import android.app.Application
import com.example.cleanarchitecture.di.component.ApplicationComponent
import com.example.cleanarchitecture.di.component.DaggerApplicationComponent
import com.example.cleanarchitecture.di.module.AppModule
import com.example.cleanarchitecture.di.module.DbModule

class App : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .dbModule(DbModule(applicationContext))
            .build()
    }
}