package com.example.starwarsapi.characters.domain.model

sealed class Resource<T>(val data: T? = null, val errorStatus: ErrorStatusDomain? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(errorStatus: ErrorStatusDomain) : Resource<T>(errorStatus = errorStatus)
}
