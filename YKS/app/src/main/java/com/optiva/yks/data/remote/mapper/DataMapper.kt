package com.optiva.yks.data.remote.mapper

import com.optiva.yks.data.remote.dto.GitHubRepository
import com.optiva.yks.data.remote.dto.ReadMe
import com.optiva.yks.domain.model.GHRepositoryDomain
import java.net.URL

class DataMapper {

    companion object {
        fun transform(item: GitHubRepository): GHRepositoryDomain {
            return GHRepositoryDomain(
                item.name +"/"+ item.owner.login,
                item.owner.avatar_url,
                item.description
            )

        }
    }
}