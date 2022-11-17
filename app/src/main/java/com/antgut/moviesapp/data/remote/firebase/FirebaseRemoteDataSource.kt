package com.antgut.moviesapp.data.remote.firebase

import com.antgut.moviesapp.data.remote.RemoteDataRepository
import com.antgut.moviesapp.domain.Movie
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseRemoteDataSource : RemoteDataRepository {


    override suspend fun getMovie(id: String): Movie? {
        val database = Firebase.database.reference.child(id)
        val snapshots = database.get().await()
        return snapshots.getValue(FirebaseModels::class.java)?.toDomain()
    }

    override suspend fun getMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val database = Firebase.database.reference
        val snapshots = database.get().await()

        snapshots.children.forEach {
            it.getValue(FirebaseModels::class.java)?.let { movie ->
                movies.add(movie.toDomain())
            }
        }
        return movies
    }

}