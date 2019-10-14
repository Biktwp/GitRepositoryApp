package com.optiva.yks.presentation.common

import com.optiva.yks.presentation.model.RepositoryVO

interface OnRepositoryClickListener{
    fun OnRepositoryClick(repositoryListener: RepositoryVO)
}


interface onRepositoryListener {
    fun onNoteClick(position: RepositoryVO)
}