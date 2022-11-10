package com.antgut.moviesapp.data.local.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@androidx.room.Dao
interface Dao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllMovies(): List<Entity>

    @Query("SELECT * FROM $TABLE_NAME WHERE $ID = :movieId")
    fun findMovieById(movieId: String): Entity?

    @Insert(onConflict = REPLACE)
    fun save(vararg movies: Entity)

    @Delete
    fun delete(movie: Entity)
}