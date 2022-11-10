package com.antgut.moviesapp.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    var apiEndPoints: ApiEndPoints
    val baseUrl: String = "https://movies-and-shows-api.cyclic.app/"


    init {
        apiEndPoints = buildApiEndPoints()
    }

    fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun buildApiEndPoints(): ApiEndPoints {
        return buildClient().create(ApiEndPoints::class.java)
    }

    fun getMovie(id: String): ApiModel? {
        val response = apiEndPoints.getMovieById(id).execute()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    fun getMovies(): List<ApiModel> {
        val response = apiEndPoints.getAllMovies().execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

}