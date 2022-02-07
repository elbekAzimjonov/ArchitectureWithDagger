package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.api.TheMovie
import com.example.cleanarchitecture.data.retrofit.ApiService
import javax.inject.Inject

class MovieDataSource @Inject constructor(val api: ApiService) {

    suspend fun getAllMovie(): TheMovie = api.getMovie()

}