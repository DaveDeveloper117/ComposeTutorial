package com.davedevab.composetutorial.data.remote

import com.davedevab.composetutorial.data.remote.model.GameModel
import com.davedevab.composetutorial.util.Constants.Companion.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET


interface GameApi {
    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}