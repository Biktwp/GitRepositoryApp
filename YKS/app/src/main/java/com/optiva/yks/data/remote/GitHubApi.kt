package com.optiva.yks.data.remote

import com.google.gson.Gson
import com.optiva.yks.data.remote.dto.RepositoryDTO
import java.io.FileNotFoundException
import java.net.URL

class GitHubApi : EndPointInterface {

    override fun getRepositories(): List<RepositoryDTO> {
        val json = URL("https://api.github.com/repositories").readText()

        return Gson().fromJson(json, Array<RepositoryDTO>::class.java).toList()
    }
}