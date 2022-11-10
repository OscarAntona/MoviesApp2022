package com.antgut.moviesapp.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {
    @GET("movies/{id}")
    fun getMovieById(@Path("id") id: String): Call<ApiModel?>

    @GET("movies")
    fun getAllMovies(): Call<List<ApiModel>>

}