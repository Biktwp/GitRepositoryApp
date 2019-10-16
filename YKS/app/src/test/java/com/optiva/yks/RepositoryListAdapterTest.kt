package com.optiva.yks

import com.optiva.yks.presentation.adapter.RepositoryListAdapter
import com.optiva.yks.presentation.common.onRepositoryListener
import com.optiva.yks.presentation.model.RepositoryVO
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.mockito.Mock
import org.mockito.Mockito

class RepositoryListAdapterTest {

    private lateinit var repositoryListAdapter: RepositoryListAdapter

    private lateinit var onRepositoryListener: onRepositoryListener

    private var repositoryVO1 = RepositoryVO("01/23", "123", "456")
    private val repositoryVO2 = RepositoryVO("45/67", "123", "456")
    private val repositoryVO3 = RepositoryVO("89/01", "123", "456")
    private val repositoryVO4 = RepositoryVO("23/45", "123", "456")
    private val repositoryVO5 = RepositoryVO(null,null,null)

    private var repositoryVOList = listOf(repositoryVO1,repositoryVO2,repositoryVO3,repositoryVO4)
    private var repositoryVOEmptyList = emptyList<RepositoryVO>()


    @Before
    fun setUp(){

        onRepositoryListener = Mockito.mock(onRepositoryListener::class.java)

        repositoryListAdapter = RepositoryListAdapter(onRepositoryListener)

    }

    @Test
    @DisplayName("Test1 adding a list of RepositoryVO objects")
    fun addItemsTest1(){

        repositoryListAdapter.addItems(repositoryVOList)

        assertTrue(repositoryListAdapter)

    }


//    @Test
//    fun getItemCountTest(){
//
//        repositoryListAdapter.addItems()
//
//    }


}