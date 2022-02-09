package com.example.cleanarchitecture.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.utility.Resource
import com.example.cleanarchitecture.domain.api.TheMovie
import com.example.cleanarchitecture.data.repository.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    fun getAllMovie(): LiveData<Resource<TheMovie>> {
        return repository.getAllMovie()
    }

}