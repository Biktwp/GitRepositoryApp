package com.optiva.yks.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.optiva.yks.presentation.adapter.RepositoryListAdapter
import com.optiva.yks.R
import com.optiva.yks.databinding.MainFragmentBinding
import com.optiva.yks.presentation.common.OnRepositoryClickListener
import com.optiva.yks.presentation.common.onRepositoryListener
import com.optiva.yks.presentation.model.RepositoryList
import com.optiva.yks.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), onRepositoryListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()
    lateinit var binding: MainFragmentBinding
    lateinit var listener: OnRepositoryClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = activity as OnRepositoryClickListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        binding = MainFragmentBinding.bind(view).apply {
            viewModel = this@MainFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        binding.recyclerviewReposlist.adapter = RepositoryListAdapter(this)
        binding.recyclerviewReposlist.layoutManager = LinearLayoutManager(activity)

        binding.searchEdittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.filter(s.toString())
            }

        })
        binding.viewModel!!.loadRepoList()


        return view
    }

    override fun onNoteClick(position: RepositoryList) {
        listener.OnRepositoryClick(position)
    }


}
