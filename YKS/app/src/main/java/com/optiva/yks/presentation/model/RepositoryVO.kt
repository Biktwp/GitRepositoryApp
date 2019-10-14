package com.optiva.yks.presentation.model

import java.io.Serializable

data class RepositoryVO(
    val rep_name: String?,
    val url: String?,
    val description: String?
) : Serializable