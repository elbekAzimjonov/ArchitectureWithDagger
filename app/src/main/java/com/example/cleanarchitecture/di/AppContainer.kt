package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.data.MovieDataSource
import com.example.cleanarchitecture.presentation.ViewModel.ViewModelFactory
import com.example.cleanarchitecture.data.retrofit.ApiClient
import com.example.cleanarchitecture.data.repository.MovieRepository

class AppContainer(context: Context) {
    private val movieDataSource = MovieDataSource(ApiClient.apiService)
    private val movieRepository = MovieRepository(movieDataSource)
    val viewModelFactory = ViewModelFactory(movieRepository)
}