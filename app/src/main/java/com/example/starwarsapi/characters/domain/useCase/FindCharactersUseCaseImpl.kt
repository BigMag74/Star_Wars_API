package com.example.starwarsapi.characters.domain.useCase

import com.example.starwarsapi.characters.data.network.CharacterDto
import com.example.starwarsapi.characters.domain.model.ErrorStatusDomain
import com.example.starwarsapi.characters.domain.model.Resource
import com.example.starwarsapi.characters.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FindCharactersUseCaseImpl(private val repository: CharactersRepository) :
    FindCharactersUseCase {
    override fun execute(): Flow<Pair<List<CharacterDto>?, ErrorStatusDomain?>> {
        return repository.findCharacters().map { result ->
            when (result) {

                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(null, result.errorStatus)
                }
            }
        }
    }
}