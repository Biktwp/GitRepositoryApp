package com.optiva.yks.utils.di

import com.optiva.yks.data.DataSource
import com.optiva.yks.data.Repository
import com.optiva.yks.data.remote.EndPointInterface
import com.optiva.yks.data.remote.GitHubApi
import com.optiva.yks.data.remote.RemoteDataSource
import com.optiva.yks.domain.usecase.GetAllRepositories
import com.optiva.yks.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val applicationModule = module {

    single { GitHubApi() as EndPointInterface }
    single { RemoteDataSource(get()) } bind DataSource::class
    single { Repository(get()) } bind DataSource::class

    single { GetAllRepositories(get()) }

    viewModel { MainViewModel(get()) }
}