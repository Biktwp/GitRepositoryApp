package com.optiva.yks.data.remote

import com.optiva.yks.data.remote.dto.GitHubRepository
import com.optiva.yks.data.remote.dto.ReadMe


interface EndPointInterface {

    fun getRepositories(): List<GitHubRepository>
    fun getReadMe(url : String): ReadMe?

}