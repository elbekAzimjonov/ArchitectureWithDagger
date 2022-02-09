package com.example.cleanarchitecture.data.retrofit

import androidx.lifecycle.LiveData
import com.example.cleanarchitecture.data.db.CastDao
import com.example.cleanarchitecture.domain.api.Cast
import com.example.cleanarchitecture.domain.api.TheMovie
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    val api: ApiService
) {
    @Inject
    lateinit var castDao: CastDao

    suspend fun getAllMovie(): TheMovie = api.getMovie()

    suspend fun getAllData(): LiveData<List<Cast>> = castDao.getAllCast()

    suspend fun insertData(cast: Cast) {
        castDao.insertCast(cast)
    }
}