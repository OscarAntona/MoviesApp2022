package com.antgut.moviesapp.domain

interface MoviesRepository {
    suspend fun getAllMovies(): List<Movie>
    suspend fun getMovieById(id: String): Movie?
}