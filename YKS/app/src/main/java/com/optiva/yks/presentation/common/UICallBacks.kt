package com.optiva.yks.presentation.common

import com.optiva.yks.presentation.model.RepositoryList

interface OnRepositoryClickListener{
    fun OnRepositoryClick(repositoryListener: RepositoryList)
}


interface onRepositoryListener {
    fun onNoteClick(position: Int)
}