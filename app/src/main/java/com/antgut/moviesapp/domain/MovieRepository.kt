package com.antgut.moviesapp.domain

interface MoviesRepository {
    fun getAllMovies(): List<Movie>
    fun getMovieById(id: String): Movie?
}