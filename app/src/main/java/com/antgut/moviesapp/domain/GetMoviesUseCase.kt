package com.antgut.moviesapp.domain

class GetMoviesUseCase(val repository: MoviesRepository) {
    fun execute(): List<MoviesFeed> {
        return repository.getAllMovies().map {
            MoviesFeed(
                it.poster,
                it.title,
                it.year,
                it.rating
            )
        }
    }

    data class MoviesFeed(
        val poster: String,
        val title: String,
        val year: String,
        val rating: String
    )
}
