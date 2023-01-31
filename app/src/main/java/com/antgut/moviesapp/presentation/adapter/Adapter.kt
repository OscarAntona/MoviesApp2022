package com.antgut.moviesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antgut.moviesapp.R
import com.antgut.moviesapp.domain.GetMoviesUseCase

class Adapter: RecyclerView.Adapter<ViewHolder>(){

    private val dataSet = mutableListOf<GetMoviesUseCase.AllMovies>()
    private var item: ((String) -> Unit)? = null


    fun setDataItems(movies: List<GetMoviesUseCase.AllMovies>){
        dataSet.clear()
        dataSet.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}