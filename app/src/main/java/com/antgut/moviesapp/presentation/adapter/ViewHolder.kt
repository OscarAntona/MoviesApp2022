package com.antgut.moviesapp.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.antgut.app.extensions.loadImage
import com.antgut.moviesapp.databinding.ActivityItemBinding
import com.antgut.moviesapp.domain.GetMoviesUseCase

class ViewHolder (private val view: View): RecyclerView.ViewHolder(view){
    fun bind(movie: GetMoviesUseCase.AllMovies, item: ((String) -> Unit)?){
        val binding = ActivityItemBinding.bind(view)
        binding.image.loadImage(movie.poster)
        binding.itemTitle.text = movie.title
        binding.year.text = movie.year
        binding.rate.text = movie.rating

        view.setOnClickListener {
            item?.invoke(movie.id)
        }


    }
}