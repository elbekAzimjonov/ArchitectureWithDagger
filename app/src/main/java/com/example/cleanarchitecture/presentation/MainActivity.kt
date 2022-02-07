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
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var movieViewModel: MovieViewModel

    private lateinit var movieList: List<Cast>
    private lateinit var castAdapter: CastAdapter
    private lateinit var castRecycler: RecyclerView
    private lateinit var castLoading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
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
                    castLoading.visibility = View.INVISIBLE
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun bindView() {
        movieList = ArrayList()
        castLoading = findViewById(R.id.loadingCast)
        castRecycler = findViewById(R.id.castRecycler)

    }
}