package com.optiva.yks

import android.text.style.TtsSpan
import com.optiva.yks.data.remote.EndPointInterface
import com.optiva.yks.data.remote.RemoteDataSource
import com.optiva.yks.data.remote.dto.Owner
import com.optiva.yks.data.remote.dto.RepositoryDTO
import com.optiva.yks.domain.model.RepositoryBO
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import com.optiva.yks.utils.Result
import com.optiva.yks.utils.di.applicationModule
import org.junit.jupiter.api.Assertions.*
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class RemoteDataSourceTest : KoinTest {

    lateinit var remoteDataSource: RemoteDataSource

    //val endPointInterface: EndPointInterface by inject()
    lateinit var endPointInterface : EndPointInterface

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

    val repositoryDTOList: List<RepositoryDTO> = listOf(repositoryDTO, repositoryDTO, repositoryDTO)

    val repositoryBO: RepositoryBO = RepositoryBO("/", "", "")

    val repositoryBOList: List<RepositoryBO> = listOf(repositoryBO, repositoryBO, repositoryBO)


    @Before
    fun setUp() {
        startKoin {
            modules(applicationModule)
        }

        endPointInterface = Mockito.mock(EndPointInterface::class.java)
        remoteDataSource = RemoteDataSource(endPointInterface)
    }

    @Test

    fun getRepositoryListTest() {


        Mockito.`when`(endPointInterface.getRepositories()).thenReturn(repositoryDTOList)
        val result = Result.Response(repositoryBOList)
        val value = remoteDataSource.getRepositoryList()



    }

}