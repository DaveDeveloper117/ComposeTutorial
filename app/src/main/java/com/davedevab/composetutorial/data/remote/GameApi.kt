package com.davedevab.composetutorial.data.remote

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import com.davedevab.composetutorial.data.remote.model.GameModel
import com.davedevab.composetutorial.util.Constants.Companion.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface GameApi {
    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}