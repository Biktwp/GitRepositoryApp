package com.optiva.yks.data

import com.optiva.yks.domain.model.GHRepositoryDomain

import com.optiva.yks.utils.Result
import org.koin.core.KoinComponent

interface DataSource: KoinComponent {

    fun getRepositoryList() : Result<List<GHRepositoryDomain>>

}