package com.optiva.yks.presentation.mapper

import com.optiva.yks.domain.model.GHRepositoryDomain
import com.optiva.yks.presentation.model.RepositoryList


class PresentationMapper {

    companion object {
        fun transform(repository: GHRepositoryDomain): RepositoryList {
            return RepositoryList(
                repository.rep_name,
                repository.url,
                repository.description
            )
        }
    }
}