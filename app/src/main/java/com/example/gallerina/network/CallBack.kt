package com.example.gallerina.network

interface CallBack<T> {
    fun onSuccess(result: T)

    fun onFailed(exception: Exception)
}