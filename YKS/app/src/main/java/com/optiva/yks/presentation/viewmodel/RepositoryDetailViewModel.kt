package com.optiva.yks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optiva.yks.presentation.model.RepositoryVO

class RepositoryDetailViewModel : ViewModel() {

    private val _repository: MutableLiveData<RepositoryVO> by lazy { MutableLiveData<RepositoryVO>() }
    val repository: LiveData<RepositoryVO>
        get() = _repository


    fun loadRepository(repository: RepositoryVO) {
        _repository.value = repository
    }

}