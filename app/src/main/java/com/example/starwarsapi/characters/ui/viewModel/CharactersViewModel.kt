package com.example.starwarsapi.characters.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.starwarsapi.characters.data.network.CharacterDto
import com.example.starwarsapi.characters.ui.CharactersState
import kotlinx.coroutines.CoroutineExceptionHandler

class CharactersViewModel() : ViewModel() {

    private val _state = MutableLiveData<CharactersState>()
    val state: LiveData<CharactersState> = _state

    private var characters: List<CharacterDto>? = null

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, _ -> setState(CharactersState.Error) }



















    private fun setState(state: CharactersState) {
        _state.value = state
    }

}