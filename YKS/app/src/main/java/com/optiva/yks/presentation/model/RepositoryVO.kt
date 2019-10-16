package com.optiva.yks.presentation.model

import java.io.Serializable

data class RepositoryVO(
    var rep_name: String?,
    var url: String?,
    var description: String?
) : Serializable