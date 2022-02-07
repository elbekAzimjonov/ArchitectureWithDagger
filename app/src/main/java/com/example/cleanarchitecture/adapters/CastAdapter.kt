package com.example.cleanarchitecture.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.api.Cast

class CastAdapter(private val castList: List<Cast>) :
    RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    inner class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(cast: Cast) {
            val name = itemView.findViewById<TextView>(R.id.movieName)
            val actorImage = itemView.findViewById<ImageView>(R.id.movieImage)
            val title = itemView.findViewById<TextView>(R.id.movieTitle)
            name.text = cast.name
            title.text = cast.character
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${cast.profile_path}")
                .transform(CenterCrop())
                .placeholder(R.drawable.the_movie)
                .into(actorImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return CastViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.onBind(castList[position])
    }

    override fun getItemCount() = castList.size
}