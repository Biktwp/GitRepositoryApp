

package com.optiva.yks

import com.optiva.yks.domain.model.RepositoryBO
import com.optiva.yks.domain.usecase.GetAllRepositories
import com.optiva.yks.presentation.viewmodel.MainViewModel
import com.optiva.yks.utils.di.applicationModule
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainViewModelTest : KoinTest {


    val usecase : GetAllRepositories by inject()
    lateinit var viewModel: MainViewModel  //by inject()

    @Before
    fun setUpMocks() {
        startKoin {
            modules(applicationModule)
        }


        this.viewModel = MainViewModel(this.usecase)

    }


    @Test
    fun loadRepoList() {
//        Mockito.`when`(this.usecase.invoke(GetAllRepositories.Params(""))).thenAnswer{
//            return@thenAnswer ArgumentMatchers.anyList<GHRepositoryDomain>()
//        }

        this.viewModel.loadRepoList()

        assertNotNull(this.viewModel.repoVO.value)

    }

}

