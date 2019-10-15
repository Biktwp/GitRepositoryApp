package com.optiva.yks.presentation.adapter

import android.widget.ImageView
import android.widget.TextView
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

    @BindingAdapter("app:rep_name")
    @JvmStatic
    fun splitRepName(text: TextView, name: String){
        text.setText(name.split("/")[0])
    }


    @BindingAdapter("app:user_name")
    @JvmStatic
    fun splitUserName(text: TextView, name: String){
        text.setText(name.split("/")[1])
    }


}