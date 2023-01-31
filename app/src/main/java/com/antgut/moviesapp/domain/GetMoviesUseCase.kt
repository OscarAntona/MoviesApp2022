package com.antgut.moviesapp.domain

class GetMoviesUseCase(val repository: MoviesRepository) {
    suspend fun execute(): List<AllMovies> {
        val movies = repository.getAllMovies()
        val moviesList = movies.map {
            AllMovies(
                it.poster,
                it.title,
                it.year,
                it.rating
            )
        }
        return moviesList
    }

    data class AllMovies(
        val poster: String,
        val title: String,
        val year: String,
        val rating: String
    )
}
