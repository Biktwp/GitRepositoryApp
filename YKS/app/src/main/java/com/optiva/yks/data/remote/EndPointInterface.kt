package com.optiva.yks.data.remote

import com.optiva.yks.data.remote.dto.RepositoryDTO


interface EndPointInterface {

    fun getRepositories(): List<RepositoryDTO>

}