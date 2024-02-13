package com.example.starwarsapi.characters.ui

import com.example.starwarsapi.characters.data.network.CharacterDto

sealed interface CharactersState {
    data object Load : CharactersState

    data object Error : CharactersState

    data class Content(val characters: List<CharacterDto>) : CharactersState

}