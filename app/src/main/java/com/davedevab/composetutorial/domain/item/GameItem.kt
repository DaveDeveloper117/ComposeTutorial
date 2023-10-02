package com.davedevab.composetutorial.domain.item

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import com.davedevab.composetutorial.data.remote.model.GameModel

data class GameItem(

    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val game_url: String,
    val genre: String,
    val platform: String

)

fun GameModel.toGameItem() = GameItem(id, title, thumbnail, short_description, game_url, genre, platform)