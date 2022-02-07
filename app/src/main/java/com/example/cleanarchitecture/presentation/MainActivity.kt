package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.utility.Status
import com.example.cleanarchitecture.presentation.ViewModel.MovieViewModel
import com.example.cleanarchitecture.adapters.CastAdapter
import com.example.cleanarchitecture.api.Cast
import com.example.cleanarchitecture.di.App

class MainActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieList: List<Cast>
    private lateinit var castAdapter: CastAdapter
    private lateinit var castRecycler: RecyclerView
    private lateinit var castLoading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieList = ArrayList()
        castLoading = findViewById(R.id.loadingCast)
        castRecycler = findViewById(R.id.castRecycler)
        val appContainer = (application as App).appContainer
        movieViewModel = appContainer.viewModelFactory.create(MovieViewModel::class.java)

        movieViewModel.getAllMovie().observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    castLoading.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {

                    castLoading.visibility = View.INVISIBLE
                    castAdapter = CastAdapter(it.data!!.credits.cast)
                    castRecycler.adapter = castAdapter

                }
                Status.ERROR -> {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}