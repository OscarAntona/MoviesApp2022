package com.antgut.moviesapp.domain

class GetMovieUseCase(val repository: MoviesRepository) {

    fun execute(id: String): DetailMovie {
        val movie = repository.getMovieById(id)!!
        return DetailMovie(
            movie.poster, movie.title, movie.plot, movie.genre, movie.rating, movie.year
        )
    }

    data class DetailMovie(
        val poster: String,
        val title: String,
        val plot: String,
        val genre: String,
        val rating: String,
        val year: String
    )
}
