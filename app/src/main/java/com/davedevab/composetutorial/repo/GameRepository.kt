package com.davedevab.composetutorial.repo

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import com.davedevab.composetutorial.data.remote.GameService
import com.davedevab.composetutorial.domain.item.GameItem
import com.davedevab.composetutorial.domain.item.toGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {
    suspend fun getGames(): List<GameItem>{
        return gameService.getGames().map {
            it.toGameItem()
        }
    }
}