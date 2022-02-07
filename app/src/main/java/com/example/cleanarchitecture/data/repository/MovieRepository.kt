package com.example.cleanarchitecture.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.data.MovieDataSource
import com.example.cleanarchitecture.utility.Resource
import com.example.cleanarchitecture.api.TheMovie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MovieRepository(private val movieDataSource: MovieDataSource) {

    private val movieData = MutableLiveData<Resource<TheMovie>>()

    init {
        fetchMovie()
    }

    private fun fetchMovie() {
        GlobalScope.launch {
            movieData.postValue(Resource.loading(null))
            try {
                coroutineScope {
                    val async = async { movieDataSource.getAllMovie() }
                    val movieList = async.await()
                    movieData.postValue(Resource.success(movieList))
                }
            } catch (e: Exception) {
                movieData.postValue(Resource.error(e.message!!, null))
            }
        }
    }

    fun getAllMovie(): LiveData<Resource<TheMovie>> {
        return movieData
    }
}