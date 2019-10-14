package com.optiva.yks.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.optiva.yks.presentation.model.RepositoryList
import com.optiva.yks.databinding.RepositoryItemBinding
import com.optiva.yks.presentation.common.onRepositoryListener

class RepositoryListAdapter(private val onRepositoryListener: onRepositoryListener) :
    RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    private val items: MutableList<RepositoryList> = mutableListOf()
    private val repositoryListener = onRepositoryListener

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding, repositoryListener
        )
    }

    fun addItems(dataset: List<RepositoryList>) {
        items.clear()
        items.addAll(dataset)
        notifyDataSetChanged()
    }


    class ViewHolder(
        private val binding: RepositoryItemBinding,
        private val onRepositoryListener: onRepositoryListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        override fun onClick(v: View?) {
            onRepositoryListener.onNoteClick(adapterPosition)
        }

        fun bind(repositoryList: RepositoryList) {
            binding.repository = repositoryList
            binding.root.setOnClickListener(this)
            binding.executePendingBindings()
        }
    }


}

