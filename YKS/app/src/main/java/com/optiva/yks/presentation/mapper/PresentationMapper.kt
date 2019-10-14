package com.optiva.yks.presentation.mapper

import com.optiva.yks.domain.model.RepositoryBO
import com.optiva.yks.presentation.model.RepositoryVO


class PresentationMapper {

    companion object {
        fun transform(repository: RepositoryBO): RepositoryVO {
            return RepositoryVO(
                repository.rep_name,
                repository.url,
                repository.description
            )
        }
    }
}