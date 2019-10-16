package com.optiva.yks


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.optiva.yks.presentation.model.RepositoryVO
import com.optiva.yks.presentation.viewmodel.RepositoryDetailViewModel
import com.optiva.yks.utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.koin.test.KoinTest

class RepositoryDetailViewModelTest : KoinTest {

    private lateinit var repositoryDetailsViewModel: RepositoryDetailViewModel

    private var repositoryVO1 = RepositoryVO("01/23", "123", "456")
    private val repositoryVO2 = RepositoryVO("45/67", "123", "456")
    private val repositoryVO3 = RepositoryVO("89/01", "123", "456")
    private val repositoryVO4 = RepositoryVO("23/45", "123", "456")
    private val repositoryVO5 = RepositoryVO(null,null,null)


    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp(){

        repositoryDetailsViewModel = RepositoryDetailViewModel()

    }


    @Test
    @DisplayName("Live Data test")
    fun loadRepositoryTest1(){

        mainCoroutineRule.pauseDispatcher()

        repositoryDetailsViewModel.loadRepository(repositoryVO1)


        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().description == "456")
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().rep_name == "01/23")
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().url == "123")

        repositoryVO1.url = ""
        repositoryVO1.description = ""
        repositoryVO1.rep_name = "45/67"

        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().url == "")
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().rep_name == "45/67")
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().description == "")


        mainCoroutineRule.resumeDispatcher()

    }


    @Test
    @DisplayName("Live Data test null")
    fun loadRepositoryTest2(){

        mainCoroutineRule.pauseDispatcher()

        repositoryDetailsViewModel.loadRepository(repositoryVO5)


        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().description.isNullOrEmpty())
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().rep_name.isNullOrEmpty())
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().url.isNullOrEmpty())

        repositoryVO5.url = ""
        repositoryVO5.description = ""
        repositoryVO5.rep_name = "45/67"

        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().url == "")
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().rep_name == "45/67")
        assertTrue(repositoryDetailsViewModel.repository.getOrAwaitValue().description == "")


        mainCoroutineRule.resumeDispatcher()

    }

}



