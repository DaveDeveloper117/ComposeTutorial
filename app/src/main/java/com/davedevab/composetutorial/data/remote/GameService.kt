package com.davedevab.composetutorial.data.remote

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import com.davedevab.composetutorial.data.remote.model.GameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameService @Inject constructor(private val gameApi: GameApi) {
    suspend fun getGames(): List<GameModel>{
        return withContext(Dispatchers.IO){
            val games = gameApi.getGames()
            games.body() ?: emptyList()
        }
    }
}