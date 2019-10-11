package com.optiva.yks.utils

sealed class Result<out T : Any> {

    class Response<out T : Any>(val data: T) : Result<T>()

    class Error(val error: String? = null) : Result<Nothing>()

}