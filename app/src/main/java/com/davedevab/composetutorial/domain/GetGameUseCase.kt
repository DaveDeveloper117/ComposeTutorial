package com.davedevab.composetutorial.domain

import com.davedevab.composetutorial.domain.item.GameItem
import com.davedevab.composetutorial.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem>{
        return gameRepository.getGames().shuffled()
    }
}