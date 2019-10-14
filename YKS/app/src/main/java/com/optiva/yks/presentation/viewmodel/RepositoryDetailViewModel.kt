package com.optiva.yks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optiva.yks.presentation.model.RepositoryList

class RepositoryDetailViewModel : ViewModel(){

    private val _repository: MutableLiveData<RepositoryList> by lazy { MutableLiveData<RepositoryList>() }
    val repository: LiveData<RepositoryList>
        get() = _repository

    var rep_name: String = ""


    var user_name: String = ""



    fun loadRepository(repository : RepositoryList){
        _repository.value = repository
        rep_name =repository.rep_name!!.substring(0, repository.rep_name!!.indexOf('/'))

        user_name = repository.rep_name!!.substring(
            repository.rep_name!!.indexOf('/'),
            repository.rep_name!!.length - 1)
    }

}