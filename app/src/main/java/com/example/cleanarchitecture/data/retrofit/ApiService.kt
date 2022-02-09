package com.example.cleanarchitecture.data.retrofit

import com.example.cleanarchitecture.domain.api.TheMovie
import retrofit2.http.GET

interface ApiService {
    @GET("movie/634649?api_key=fab3626d9e8d767dbf679f3c64849db5&append_to_response=credits")
    suspend fun getMovie(): TheMovie
}