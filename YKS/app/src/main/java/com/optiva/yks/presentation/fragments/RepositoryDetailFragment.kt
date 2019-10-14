package com.optiva.yks.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.optiva.yks.R
import com.optiva.yks.databinding.RepositoryDetailsBinding
import com.optiva.yks.presentation.viewmodel.RepositoryDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryDetailFragment : Fragment(){

    companion object {
        fun newInstance() = RepositoryDetailFragment()
    }

    private val viewModel: RepositoryDetailViewModel = RepositoryDetailViewModel()

    lateinit var binding: RepositoryDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.repository_details, container, false)

        binding = RepositoryDetailsBinding.bind(view).apply {
            repository = this@RepositoryDetailFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }



        return view
    }
}