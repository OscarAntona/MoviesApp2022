package com.antgut.moviesapp.data.remote
import com.antgut.moviesapp.domain.Movie

interface RemoteDataRepository {
    fun getMovies():List<Movie>
    fun getMovie(id:String):Movie?
}