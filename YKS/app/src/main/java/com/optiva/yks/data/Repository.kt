package com.optiva.yks.data

import com.optiva.yks.data.remote.RemoteDataSource
import com.optiva.yks.domain.model.GHRepositoryDomain
import com.optiva.yks.utils.Result


class Repository(private val remoteDataSource: RemoteDataSource) : DataSource{
    override fun getRepositoryList(): Result<List<GHRepositoryDomain>> {
        return remoteDataSource.getRepositoryList()
    }

}