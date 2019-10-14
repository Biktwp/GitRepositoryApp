package com.optiva.yks

import com.optiva.yks.data.remote.GitHubApi
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GitHubApiTest {


    lateinit var gitHubApi: GitHubApi


    @Before
    fun setUp(){

        gitHubApi = GitHubApi()

    }

    @Test

    fun getRepositoryTest(){
        assertNotNull(this.gitHubApi.getRepositories())
    }

}