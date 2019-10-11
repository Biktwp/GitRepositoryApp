package com.optiva.yks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.optiva.yks.presentation.model.RepositoryList

class RepositoryDetailViewModel {

    private val _repository: MutableLiveData<RepositoryList> by lazy { MutableLiveData<RepositoryList>() }
    val repository: LiveData<RepositoryList>
        get() = _repository

    val rep_name: String =
        _repository.value!!.rep_name!!.substring(0, _repository.value!!.rep_name!!.indexOf('/'))

    val user_name: String = _repository.value!!.rep_name!!.substring(
        repository.value!!.rep_name!!.indexOf('/'),
        repository.value!!.rep_name!!.length - 1
    )


    fun loadRepository(repository : RepositoryList){
        _repository.value = repository
    }

}