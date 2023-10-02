package com.davedevab.composetutorial.ui.home

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davedevab.composetutorial.domain.GetGameUseCase
import com.davedevab.composetutorial.domain.item.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getGameUseCase: GetGameUseCase ) : ViewModel(){
    private val _games = MutableStateFlow(emptyList<GameItem>())
    val games : StateFlow<List<GameItem>> get() = _games

    init {
        getGames()
    }

    private fun getGames(){
        viewModelScope.launch {
            try {
                val games = getGameUseCase()
                _games.value = games
            }catch (_: Exception){

            }
        }
    }

}