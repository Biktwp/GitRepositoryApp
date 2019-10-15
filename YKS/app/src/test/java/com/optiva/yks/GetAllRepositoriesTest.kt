package com.optiva.yks

import com.optiva.yks.data.Repository
import com.optiva.yks.domain.model.RepositoryBO
import com.optiva.yks.domain.usecase.GetAllRepositories
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.mockito.Mockito
import com.optiva.yks.utils.Result
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows
import java.lang.NullPointerException

class GetAllRepositoriesTest {


    lateinit var getAllRepositories: GetAllRepositories

    lateinit var repository: Repository


    val repositoryBO1: RepositoryBO = RepositoryBO("1/", "", "")
    val repositoryBO2: RepositoryBO = RepositoryBO("2/", "", "")
    val repositoryBO3: RepositoryBO = RepositoryBO("3/", "", "")

    val repositoryBOList: List<RepositoryBO> = listOf(repositoryBO1, repositoryBO2, repositoryBO3)

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)

        repository = Mockito.mock(Repository::class.java)

        getAllRepositories = GetAllRepositories(repository)

    }


    @After
    fun teardown() {

        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    @DisplayName("Test 1 Checking return type")
    fun useCaseTest1() = runBlocking {

        var cosa = false
        Mockito.`when`(repository.getRepositoryList())
            .thenReturn(Result.Response(repositoryBOList))

        launch(Dispatchers.IO) {

            getAllRepositories.invoke(GetAllRepositories.Params("")) {
                cosa = it is Result.Response
            }

        }
        delay(50)
        assertTrue(cosa)
    }

    @Test
    @DisplayName("Test2 Checking return object")
    fun useCaseTest2() = runBlocking {

        var cosa = false
        Mockito.`when`(repository.getRepositoryList())
            .thenReturn(Result.Response(repositoryBOList))

        launch(Dispatchers.IO) {

            getAllRepositories.invoke(GetAllRepositories.Params("")) {

                it as Result.Response
                cosa = it.data.containsAll(repositoryBOList)
            }

        }
        delay(50)
        assertTrue(cosa)
    }

    @Test
    @DisplayName("Test3 Checking Error result")
    fun useCaseTest3() = runBlocking {

        var cosa = false
        Mockito.`when`(repository.getRepositoryList())
            .thenReturn(Result.Error())

        launch(Dispatchers.IO) {

            getAllRepositories.invoke(GetAllRepositories.Params("")) {

                cosa = it is Result.Error
            }

        }
        delay(50)
        assertTrue(cosa)
    }


    @Test
    @DisplayName("Test4 Checking valid filter")
    fun useCaseTest4() = runBlocking {

        var cosa = false
        Mockito.`when`(repository.getRepositoryList())
            .thenReturn(Result.Response(repositoryBOList))

        launch(Dispatchers.IO) {

            getAllRepositories.invoke(GetAllRepositories.Params("1")) {

                it as Result.Response
                cosa = it.data.containsAll(listOf(repositoryBO1))

            }

        }
        delay(50)
        assertTrue(cosa)
    }


    @Test
    @DisplayName("Test5 Checking invalid filter")
    fun useCaseTest5() = runBlocking {

        var cosa = false
        Mockito.`when`(repository.getRepositoryList())
            .thenReturn(Result.Response(repositoryBOList))

        launch(Dispatchers.IO) {

            getAllRepositories.invoke(GetAllRepositories.Params("5")) {

                it as Result.Response
                cosa = it.data.containsAll(emptyList())

            }

        }
        delay(50)
        assertTrue(cosa)
    }


}