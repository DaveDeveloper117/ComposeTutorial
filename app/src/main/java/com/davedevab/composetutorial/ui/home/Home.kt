package com.davedevab.composetutorial.ui.home

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val openUrl = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Aquí puedes manejar la respuesta si es necesario, pero en este caso, no es necesario.
    }

    Card(
        shape =  RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
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
            Column(modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = game.title, fontWeight = FontWeight.Bold, fontSize = 22.sp, modifier = Modifier.padding(bottom = 8.dp))
                Text(
                    text = game.short_description,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable {
                            isExpanded = !isExpanded
                        }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AssistChip(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = { /* Do something! */ },
                        label = { Text(game.genre) },
                        shape = RoundedCornerShape(12.dp)
                        )
                    AssistChip(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = { /* Do something! */ },
                        label = { Text(game.platform) },
                        shape = RoundedCornerShape(12.dp)

                    )
                }
                Button(
                    onClick = {
                        // Acción para el primer botón
                        val url = game.game_url // Supongamos que el modelo proporciona la URL
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        openUrl.launch(intent)
                    },
                    modifier = Modifier
                        .padding(6.dp)
                ) {
                    Text(text = "View Site Game", fontSize = 14.sp)
                }
            }
        }
    }
}

