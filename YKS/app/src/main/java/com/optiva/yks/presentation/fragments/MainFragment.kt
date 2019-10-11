package com.optiva.yks.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.optiva.yks.presentation.adapter.RepositoryListAdapter
import com.optiva.yks.R
import com.optiva.yks.databinding.MainFragmentBinding
import com.optiva.yks.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), RepositoryListAdapter.onRepositoryListener {
    override fun onNoteClick(position: Int) {

            .beginTransaction()
            .replace(
                R.id.container,
                MainFragment.newInstance()
            ).commit()
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()
    lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        binding = MainFragmentBinding.bind(view).apply {
            viewModel = this@MainFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        binding.recyclerviewReposlist.adapter = RepositoryListAdapter()
        binding.recyclerviewReposlist.layoutManager = LinearLayoutManager(activity)

        binding.searchEdittext.addTextChangedListener(object : TextWatcher{
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



}
