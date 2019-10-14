package com.optiva.yks.data.remote

import com.optiva.yks.data.remote.dto.RepositoryDTO
import com.optiva.yks.data.remote.dto.ReadMe


interface EndPointInterface {

    fun getRepositories(): List<RepositoryDTO>
    fun getReadMe(url : String): ReadMe?

}