package com.optiva.yks.presentation.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.optiva.yks.presentation.model.RepositoryVO
import com.squareup.picasso.Picasso

object BindingAdapter {

    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView,items: List<RepositoryVO>){
        recyclerView.adapter.let {
            if (it is RepositoryListAdapter) it.addItems(items)
        }
    }

    @BindingAdapter("android:src")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?){
        if(!url.isNullOrEmpty()) Picasso.get().load(url).into(imageView)
    }


}