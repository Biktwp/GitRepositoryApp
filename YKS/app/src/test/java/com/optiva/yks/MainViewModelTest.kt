package com.optiva.yks

import com.optiva.yks.domain.usecase.GetAllRepositories
import com.optiva.yks.presentation.viewmodel.MainViewModel
import io.mockk.*
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private val usecase : GetAllRepositories = mockk(relaxed = true)

    val viewModel = MainViewModel(usecase)

    @Before
    fun setUpMocks(){
        clearAllMocks()

    }


    @Test
    fun `OnStart`(){

    }

}