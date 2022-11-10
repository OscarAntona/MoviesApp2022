package com.antgut.moviesapp.data.local

import com.antgut.moviesapp.domain.Movie

interface LocalDataRepository {
    fun getMovies(): List<Movie>
    fun getMovie(id: String): Movie?
    fun saveMovies(list: List<Movie>)
}