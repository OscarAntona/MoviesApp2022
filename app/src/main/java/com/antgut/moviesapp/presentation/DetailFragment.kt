package com.antgut.moviesapp.presentation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.antgut.moviesapp.databinding.FragmentDetailBinding
import com.antgut.moviesapp.domain.GetMovieUseCase


class DetailFragment : Fragment(){
    private var viewModel: DetailViewModel?= null
    private var binding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = FactoryMovies().getDetailViewModel(
            requireContext()
        )
        setupObservers()
        viewModel?.loadDetail(getMovieId())
    }
    private fun setupObservers() {
        val movieDetailSuscriber =
            Observer<DetailViewModel.DetailUiState> { uiState ->
                uiState.movieDetailFeed?.let {
                    bind(it)
                }
            }
        viewModel?.detailPublisher?.observe(viewLifecycleOwner, movieDetailSuscriber)
    }
    private fun getMovieId(): String = arguments?.getString("key_movie") ?: "a"

    private fun bind(model: GetMovieUseCase.DetailMovie) {
        binding?.apply {
            detailTitle.text = model.title
            detailGenre.text = model.genre
            detailPlot.text = model.plot
            detailYear.text = model.year
            detailRate.text = model.rating
        }
    }

}