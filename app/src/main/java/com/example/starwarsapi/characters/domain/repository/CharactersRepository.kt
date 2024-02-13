package com.example.starwarsapi.characters.domain.repository

import com.example.starwarsapi.characters.data.network.CharacterDto
import com.example.starwarsapi.characters.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun findCharacters(): Flow<Resource<List<CharacterDto>>>
}