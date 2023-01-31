package com.antgut.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antgut.moviesapp.domain.GetMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {

    val detailPublisher: MutableLiveData<com.antgut.moviesapp.presentation.DetailViewModel.DetailUiState> by lazy{
        MutableLiveData<com.antgut.moviesapp.presentation.DetailViewModel.DetailUiState>()
    }
    fun loadDetail(id:String){
        detailPublisher.value = com.antgut.moviesapp.presentation.DetailViewModel.DetailUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val movieDetail = getMovieUseCase.execute(id)
            detailPublisher.postValue(
                com.antgut.moviesapp.presentation.DetailViewModel.DetailUiState(
                    isLoading = false,
                    movieDetailFeed = movieDetail
                )
            )
        }
    }
    data class DetailUiState(
        val isLoading:Boolean = false,
        val movieDetailFeed: GetMovieUseCase.DetailMovie? = null
    )

}