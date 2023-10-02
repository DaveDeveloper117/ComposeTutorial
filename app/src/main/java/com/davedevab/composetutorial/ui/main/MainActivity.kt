package com.davedevab.composetutorial.ui.main

/*
 * Name: FreeGames
 * Dev: David Butrón
 * Profile Github: https://github.com/DaveDeveloper117/
 * License: https://github.com/DaveDeveloper117/ComposeTutorial/blob/master/LICENSE
 * Github Repo: https://github.com/DaveDeveloper117/ComposeTutorial
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.davedevab.composetutorial.ui.theme.ComposeTutorialTheme
import com.davedevab.composetutorial.ui.home.HomeScreen

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //@Inject
    //lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
