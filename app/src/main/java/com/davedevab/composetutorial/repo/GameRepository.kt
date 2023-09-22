package com.davedevab.composetutorial.repo

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