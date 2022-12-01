package com.antgut.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import com.antgut.moviesapp.domain.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel

class FeedViewModel (val getMoviesUseCase: GetMoviesUseCase) : ViewModel(){

    val publisher: MutableLiveData<UiState> by lazy{
        MutableLiveData<UiState>()
    }

    fun load(){
        publisher.value = UiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val moviesFeedList = getMoviesUseCase.execute()
            publisher.postValue(
                UiState(
                    isLoading = false,
                    moviesFeed = moviesFeedList
                )
            )
        }
    }

    data class UiState(
        val isLoading:Boolean = false,
        val moviesFeed: List<GetMoviesUseCase.AllMovies> = emptyList()
    )

}