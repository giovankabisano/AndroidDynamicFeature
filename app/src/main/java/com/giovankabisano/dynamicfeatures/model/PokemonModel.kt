package com.giovankabisano.dynamicfeatures.model

data class PokemonModel(
    val name: String,
    val type: PokemonType,
    val level: Int,
    val image: Int
) {
    enum class PokemonType {
        LEAF,
        WATER,
        FIRE
    }
}