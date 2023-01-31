package com.antgut.moviesapp.presentation

import android.content.Context
import com.antgut.app.data.local.db.AppDataBase
import com.antgut.moviesapp.data.DataRepository
import com.antgut.moviesapp.data.local.room.RoomLocalDataSource
import com.antgut.moviesapp.data.remote.retrofit.ApiClient
import com.antgut.moviesapp.data.remote.retrofit.RetrofitRemoteDataSource
import com.antgut.moviesapp.domain.GetMoviesUseCase

class Factory {
    fun getViewModel(applicationContext: Context):ViewModel{
        return ViewModel(
            GetMoviesUseCase(
                DataRepository(
                    RoomLocalDataSource(
                        AppDataBase.getDataBase(applicationContext).daoMovies(),
                    ),
                    RetrofitRemoteDataSource(ApiClient()),
                )
            )
        )
    }
}