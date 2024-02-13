package com.example.starwarsapi.characters.data.network

import retrofit2.http.GET

interface StarWarsApiService {

    @GET("/people")
    suspend fun getAllCharacters(): CharactersResponse
}