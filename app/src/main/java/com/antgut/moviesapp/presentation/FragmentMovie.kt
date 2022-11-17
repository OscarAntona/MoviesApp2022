package com.antgut.moviesapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.antgut.moviesapp.databinding.FragmentListBinding
import com.antgut.moviesapp.presentation.adapter.Adapter

class FragmentMovie : Fragment() {

    private var binding: FragmentListBinding? = null
    private val moviesAdapter = Adapter()
    val viewModel by lazy {
        FactoryMovies().getViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        setupView()
        return binding?.root
    }
    private fun setupView() {
        binding?.apply {
            feedListRecyclerView.apply {
                adapter = moviesAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                moviesAdapter.setOnClickItem {
                    navigateToMovieDetail(it)
                }
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.load()
    }

    private fun setupObservers() {
        val moviesFeedSuscriber =
            Observer<FeedViewModel.UiState> { uiState ->
                moviesAdapter.setDataItems(uiState.moviesFeed)
            }
        viewModel.publisher.observe(viewLifecycleOwner, moviesFeedSuscriber)
    }
    private fun navigateToMovieDetail(movieId:String){
        findNavController().navigate(
           FragmentMovieDirections.actionMoviesfeedToMoviedetail(movieId)
        )
    }
}