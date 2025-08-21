package com.vixhkey.retorfit3.Database

sealed class ApiState<out T> {
    object  Default : ApiState<Nothing>()
    object  Loading : ApiState<Nothing>()
    data  class  Error(val error: String) : ApiState<Nothing>()
    data  class  Success<T>(val data: T) : ApiState<T>()
}