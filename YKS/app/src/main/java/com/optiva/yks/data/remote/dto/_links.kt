package com.optiva.yks.data.remote.dto

import com.google.gson.annotations.SerializedName


class _links(

    @SerializedName("self") val self: String,
    @SerializedName("git") val git: String,
    @SerializedName("html") val html: String
)