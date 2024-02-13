package com.example.starwarsapi.characters.data.network

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    val name: String,
    val height: Int,
    val mass: Int,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("birth_year")
    val birthYear: String,
    val gender: String,
)
