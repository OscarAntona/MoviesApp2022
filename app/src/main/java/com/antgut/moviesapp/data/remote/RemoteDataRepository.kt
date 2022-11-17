package com.antgut.moviesapp.data.remote
import com.antgut.moviesapp.domain.Movie

interface RemoteDataRepository {
    suspend fun getMovies():List<Movie>
    suspend fun getMovie(id:String):Movie?
}