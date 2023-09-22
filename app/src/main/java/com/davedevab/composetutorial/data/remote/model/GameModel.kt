package com.davedevab.composetutorial.data.remote.model

data class GameModel(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val game_url: String
)