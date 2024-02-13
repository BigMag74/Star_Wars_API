package com.example.starwarsapi.characters.data.repositoryImpl

import com.example.starwarsapi.characters.data.network.CharacterDto
import com.example.starwarsapi.characters.data.network.CharactersResponse
import com.example.starwarsapi.characters.data.network.Response
import com.example.starwarsapi.characters.data.network.StarWarsApiService
import com.example.starwarsapi.characters.domain.model.ErrorStatusDomain
import com.example.starwarsapi.characters.domain.model.Resource
import com.example.starwarsapi.characters.domain.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class CharactersRepositoryImpl(private val starWarsApiService: StarWarsApiService) :
    CharactersRepository {
    override fun findCharacters(): Flow<Resource<List<CharacterDto>>> = flow {
        val response: Response = withContext(Dispatchers.IO) {
            try {
                val response: Response = starWarsApiService.getAllCharacters()
                response.apply { resultCode = RESPONSE_SUCCESS }
            } catch (e: Throwable) {
                Response().apply { resultCode = RESPONSE_ERROR }
            }
        }

        when (response.resultCode) {
            RESPONSE_ERROR -> {
                emit(Resource.Error(ErrorStatusDomain.NO_CONNECTION))
            }

            RESPONSE_SUCCESS -> {
                val charactersList = (response as CharactersResponse).items
                emit(Resource.Success(charactersList))
            }
            else -> {
                emit(Resource.Error(ErrorStatusDomain.ERROR_OCCURRED))
            }
        }
    }

    companion object {
        const val RESPONSE_SUCCESS = 200
        const val RESPONSE_ERROR = -1
    }
}