package com.optiva.yks.domain.usecase

import com.optiva.yks.data.Repository
import com.optiva.yks.domain.model.GHRepositoryDomain
import com.optiva.yks.utils.UseCase
import com.optiva.yks.utils.Result

class GetAllRepositories (private val repository: Repository) :
    UseCase<List<GHRepositoryDomain>, GetAllRepositories.Params>() {

    override suspend fun run(params: Params): Result<List<GHRepositoryDomain>> {
        val result = repository.getRepositoryList()

        if (result is Result.Response && params.filter != "") {
            return Result.Response( result.data .filter { ghDataList -> ghDataList.rep_name == params.filter  })
        }
        return result
    }

    class Params(internal val filter: String)
}