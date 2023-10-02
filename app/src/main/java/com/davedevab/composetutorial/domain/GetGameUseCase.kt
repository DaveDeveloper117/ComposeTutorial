package com.davedevab.composetutorial.domain

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import com.davedevab.composetutorial.domain.item.GameItem
import com.davedevab.composetutorial.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem>{
        return gameRepository.getGames().shuffled()
    }
}