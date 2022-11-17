package com.antgut.moviesapp.data.remote.retrofit

import com.antgut.moviesapp.data.remote.RemoteDataRepository
import com.antgut.moviesapp.domain.Movie

class RetrofitRemoteDataSource (val client: ApiClient) : RemoteDataRepository{

    override suspend fun getMovies(): List<Movie> {
        return client.getMovies().map {
            it.toDomain()
        }
    }

    override suspend fun getMovie(id: String): Movie? {
        return client.getMovie(id)?.toDomain()
    }

}