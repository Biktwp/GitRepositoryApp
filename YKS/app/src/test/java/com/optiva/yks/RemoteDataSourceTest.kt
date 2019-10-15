package com.optiva.yks

import com.optiva.yks.data.remote.EndPointInterface
import com.optiva.yks.data.remote.RemoteDataSource
import com.optiva.yks.data.remote.dto.Owner
import com.optiva.yks.data.remote.dto.RepositoryDTO
import com.optiva.yks.domain.model.RepositoryBO
import org.junit.Test
import org.mockito.Mockito
import com.optiva.yks.utils.Result
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.koin.test.KoinTest
import java.lang.NullPointerException

class RemoteDataSourceTest : KoinTest {

    lateinit var remoteDataSource: RemoteDataSource

    //val endPointInterface: EndPointInterface by inject()
    lateinit var endPointInterface: EndPointInterface

    val owner = Owner(
        "", 0, "", "", "", "", "",
        "", "", "", "", "",
        "", "", "", "", "", false
    )
    val repositoryDTO = RepositoryDTO(
        0, "", "", "", owner, false, "",
        "", false, "", "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", ""
    )

    val emptyList: List<RepositoryDTO> = emptyList()

    val nullList: List<RepositoryDTO>? = null

    val repositoryDTOList: List<RepositoryDTO> = listOf(repositoryDTO, repositoryDTO, repositoryDTO)

    val repositoryBO: RepositoryBO = RepositoryBO("/", "", "")

    val repositoryBOList: List<RepositoryBO> = listOf(repositoryBO, repositoryBO, repositoryBO)



    @Before
    fun setUp() {

        endPointInterface = Mockito.mock(EndPointInterface::class.java)
        remoteDataSource = RemoteDataSource(endPointInterface)
    }

    @Test
    @DisplayName("Custom test1 transform List of RepositoryDTO")
    fun getRepositoryListTest1() {
        Mockito.`when`(endPointInterface.getRepositories()).thenReturn(repositoryDTOList)
        val value = remoteDataSource.getRepositoryList()
        assertTrue(value is Result<List<RepositoryBO>>)
    }

    @Test
    @DisplayName("Custom test2 transform a empty list")
    fun getRepositoryListTest2() {
        Mockito.`when`(endPointInterface.getRepositories()).thenReturn(emptyList)
        val value = remoteDataSource.getRepositoryList()
        assertTrue(value is Result.Error)
    }

    @Test
    @DisplayName("Custom test3 transform List of RepositoryDTO to List of RepositoryBO")
    fun getRepositoryListTest3() {
        Mockito.`when`(endPointInterface.getRepositories()).thenReturn(repositoryDTOList)
        val value = remoteDataSource.getRepositoryList() as Result.Response

        assertTrue(value.data.containsAll(repositoryBOList))
    }


    @Test
    @DisplayName("Custom test4 transform an empty list")
    fun getRepositoryListTest4() {
        Mockito.`when`(endPointInterface.getRepositories()).thenReturn(nullList)

        assertThrows(NullPointerException::class.java){
            remoteDataSource.getRepositoryList()
        }
    }




}