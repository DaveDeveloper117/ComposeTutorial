package com.davedevab.composetutorial.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.davedevab.composetutorial.domain.item.GameItem

@Composable
fun HomeScreen(){
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val games by homeViewModel.games.collectAsState()

    LazyColumn{
        items(games){ game: GameItem ->

            GameCard(game = game)

        }
    }
}

@Composable
fun GameCard(game: GameItem){
    val image = rememberAsyncImagePainter(model = game.thumbnail)
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape =  RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = game.title, fontWeight = FontWeight.Bold)
                Text(
                    text = game.short_description,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .clickable {
                            isExpanded = !isExpanded
                        }
                )
            }
        }
    }
}

