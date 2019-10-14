package com.optiva.yks.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.optiva.yks.R
import com.optiva.yks.databinding.RepositoryDetailsBinding
import com.optiva.yks.presentation.model.RepositoryVO
import com.optiva.yks.presentation.viewmodel.RepositoryDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryDetailFragment : Fragment(){

    companion object {

        private const val REPOSITORY_ARG = "REPOSITORY_ARG"

        fun newInstance(repositoryVO: RepositoryVO): Fragment {
            val fragment = RepositoryDetailFragment()

            val args = Bundle()
            args.putSerializable(REPOSITORY_ARG, repositoryVO)

            fragment.arguments = args

            return fragment
        }
    }

    private val viewModel: RepositoryDetailViewModel by viewModel()

    lateinit var binding: RepositoryDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.repository_details, container, false)

        binding = RepositoryDetailsBinding.bind(view).apply {
            viewModel = this@RepositoryDetailFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        arguments?.getSerializable(REPOSITORY_ARG).also {
            viewModel.loadRepository(it as RepositoryVO)
        }




        return view
    }
}