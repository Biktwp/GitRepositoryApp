package com.optiva.yks.data.remote

import com.google.gson.Gson
import com.optiva.yks.data.remote.dto.GitHubRepository
import com.optiva.yks.data.remote.dto.ReadMe
import java.io.FileNotFoundException
import java.net.URL

class GitHubApi : EndPointInterface {
    override fun getReadMe(url: String): ReadMe? {
        try {
            val json = URL(url).readText()
            return Gson().fromJson(json, ReadMe::class.java)
        } catch (e: FileNotFoundException) {
            return null
        }
    }

    override fun getRepositories(): List<GitHubRepository> {
        val json = URL("https://api.github.com/repositories").readText()

        return Gson().fromJson(json, Array<GitHubRepository>::class.java).toList()
    }
}