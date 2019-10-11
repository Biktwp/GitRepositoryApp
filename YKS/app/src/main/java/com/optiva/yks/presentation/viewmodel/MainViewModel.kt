package com.optiva.yks.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optiva.yks.utils.Result
import com.optiva.yks.presentation.mapper.PresentationMapper.Companion.transform
import com.optiva.yks.domain.model.GHRepositoryDomain
import com.optiva.yks.domain.usecase.GetAllRepositories
import com.optiva.yks.presentation.model.RepositoryList

class MainViewModel(private val getAllRepositories: GetAllRepositories) : ViewModel() {

    private val _repoList = MutableLiveData<List<RepositoryList>>().apply { value = emptyList() }
    val repoList: LiveData<List<RepositoryList>>
        get() = _repoList

    private var repositoryList : List<RepositoryList> = emptyList()

    private val _currentFilter = MutableLiveData<String>().apply { value = "" }
    val currentFilter: LiveData<String>
        get() = _currentFilter

    fun loadRepoList(){
        getAllRepositories.invoke(GetAllRepositories.Params(_currentFilter.value!!)){
            when (it) {
                is Result.Response -> {
                    handleResponse(it.data)
                }
                is Result.Error -> {
                    handleError()
                }
            }
        }
    }

    fun filter(filter: String){
        if(filter == "")  _repoList.value = repositoryList
        else _repoList.value = repositoryList.filter { it.rep_name!!.startsWith(filter) }
    }

    private fun handleError() {
        _repoList.value = null
    }

    private fun handleResponse(response: List<GHRepositoryDomain>) {
        _repoList.value = response.map { transform(it) }
        repositoryList = _repoList.value!!
    }
}
