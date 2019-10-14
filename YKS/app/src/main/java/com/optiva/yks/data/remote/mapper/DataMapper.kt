package com.optiva.yks.data.remote.mapper

import com.optiva.yks.data.remote.dto.RepositoryDTO
import com.optiva.yks.domain.model.RepositoryBO

class DataMapper {

    companion object {
        fun transform(item: RepositoryDTO): RepositoryBO {
            return RepositoryBO(
                item.name +"/"+ item.owner.login,
                item.owner.avatar_url,
                item.description
            )

        }
    }
}