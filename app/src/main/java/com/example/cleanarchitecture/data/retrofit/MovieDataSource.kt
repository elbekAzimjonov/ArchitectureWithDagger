package com.example.cleanarchitecture.data.retrofit

import com.example.cleanarchitecture.domain.api.TheMovie
import javax.inject.Inject

class MovieDataSource @Inject constructor(val api: ApiService) {

    suspend fun getAllMovie(): TheMovie = api.getMovie()

}