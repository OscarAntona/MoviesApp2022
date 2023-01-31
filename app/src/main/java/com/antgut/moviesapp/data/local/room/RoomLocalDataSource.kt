package com.antgut.moviesapp.data.local.room

import com.antgut.moviesapp.data.local.LocalDataRepository
import com.antgut.moviesapp.domain.Movie

class RoomLocalDataSource(val moviesDao: Dao) : LocalDataRepository {

    override fun getMovies(): List<Movie> {
        return moviesDao.getAllMovies().map {
            it.toDomain()
        }
    }

    override fun getMovie(id: String): Movie? {
        return moviesDao.findMovieById(id)?.toDomain()
    }

    override fun saveMovies(list: List<Movie>) {
        val entities = list.map {
            it.toEntity()
        }
        moviesDao.save(*entities.toTypedArray())
    }
}