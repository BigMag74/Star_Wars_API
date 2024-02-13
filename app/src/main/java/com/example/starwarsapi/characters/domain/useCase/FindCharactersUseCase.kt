package com.example.starwarsapi.characters.domain.useCase

import com.example.starwarsapi.characters.data.network.CharacterDto
import com.example.starwarsapi.characters.domain.model.ErrorStatusDomain
import kotlinx.coroutines.flow.Flow

interface FindCharactersUseCase {
    fun execute(): Flow<Pair<List<CharacterDto>?, ErrorStatusDomain?>>
}