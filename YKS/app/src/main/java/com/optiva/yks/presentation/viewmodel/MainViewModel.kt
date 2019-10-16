package com.optiva.yks.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optiva.yks.utils.Result
import com.optiva.yks.presentation.mapper.PresentationMapper.Companion.transform
import com.optiva.yks.domain.model.RepositoryBO
import com.optiva.yks.domain.usecase.GetAllRepositories
import com.optiva.yks.presentation.model.RepositoryVO

class MainViewModel(private val getAllRepositories: GetAllRepositories) : ViewModel() {

    private val _repoList = MutableLiveData<List<RepositoryVO>>().apply { value = emptyList() }
    val repoVO: LiveData<List<RepositoryVO>>
        get() = _repoList

    private var repositoryVO: List<RepositoryVO> = emptyList()

    private val _currentFilter = MutableLiveData<String>().apply { value = "" }
    val currentFilter: LiveData<String>
        get() = _currentFilter

    fun loadRepoList() {
        getAllRepositories.invoke(GetAllRepositories.Params(_currentFilter.value!!)) {
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

    fun filter(filter: String) {
        if (filter == "") _repoList.value = repositoryVO
        else _repoList.value = repositoryVO.filter { it.rep_name!!.startsWith(filter) }
    }

    private fun handleError() {
        _repoList.value = null
    }

    private fun handleResponse(response: List<RepositoryBO>) {
        _repoList.value = response.map { transform(it) }
        repositoryVO = _repoList.value!!
    }
}
