@file:Suppress("DEPRECATION")

package com.optiva.yks

import com.optiva.yks.data.remote.dto.RepositoryDTO
import com.optiva.yks.data.remote.mapper.DataMapper
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class DataMapperTest {


    @Mock

    lateinit var repositoryDTO: RepositoryDTO

    @Before
    fun setUpMocks() {

       // this.repositoryDTO = RepositoryDTO()

    }


    @Test

    fun transform() {

        assertNotNull(DataMapper.transform(repositoryDTO))

    }
}
