package com.antgut.moviesapp.data

import com.antgut.moviesapp.data.local.room.RoomLocalDataSource
import com.antgut.moviesapp.data.remote.retrofit.RetrofitRemoteDataSource
import com.antgut.moviesapp.domain.Movie
import com.antgut.moviesapp.domain.MoviesRepository

class DataRepository (
    private val localSource: RoomLocalDataSource,
    private val remoteSource: RetrofitRemoteDataSource) : MoviesRepository {


    override suspend fun getAllMovies(): List<Movie> {
        var movies = localSource.getMovies()
        if(movies.isNullOrEmpty()){
            movies = remoteSource.getMovies()
            localSource.saveMovies(movies)
            return movies
        }
        return movies
    }

    override suspend fun getMovieById(id: String): Movie? {
        var movie = localSource.getMovie(id)
        if(movie == null){
            movie = remoteSource.getMovie(id)
            return movie
        }
        return movie
    }

}