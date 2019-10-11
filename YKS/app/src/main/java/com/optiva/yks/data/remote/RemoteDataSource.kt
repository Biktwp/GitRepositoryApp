package com.optiva.yks.data.remote

import com.optiva.yks.data.DataSource
import com.optiva.yks.data.remote.mapper.DataMapper
import com.optiva.yks.domain.model.GHRepositoryDomain
import com.optiva.yks.utils.Result


class RemoteDataSource(private val api: EndPointInterface) : DataSource{
    override fun getRepositoryList(): Result<List<GHRepositoryDomain>> {
        val repository = mutableListOf<GHRepositoryDomain>()
        val result = api.getRepositories()
        result.forEach {
            repository.add(DataMapper.transform(it))
        }
        return if(result.isEmpty()) Result.Error()
        else Result.Response(repository)
    }

}