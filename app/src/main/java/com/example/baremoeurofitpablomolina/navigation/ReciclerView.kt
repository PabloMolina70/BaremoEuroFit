package com.example.baremoeurofitpablomolina.navigation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baremoeurofitpablomolina.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PruebasStickyView() {
    val context = LocalContext.current

    val superhero: Map<String, List<Pruebas>> = getPruebas().groupBy { it.Name }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superhero.forEach { (name, pruebas) ->
            stickyHeader {
                Text(
                    text = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            items(pruebas) { prueba ->
                ItemPrueba(pruebas = prueba) {
                    Toast.makeText(context, it.Name, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun PruebasWithSpecialControl() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val corutineScope = rememberCoroutineScope()
    Column() {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getPruebas()) { prueba ->
                ItemPrueba(pruebas = prueba) {
                    Toast.makeText(context, it.Name, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(
                onClick = {
                    corutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un boton cool")
            }
        }
    }
}

@Composable
fun PruebasGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        modifier = Modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(getPruebas()) { prueba ->
                ItemPrueba(pruebas = prueba) {
                    Toast.makeText(context, it.Name, Toast.LENGTH_SHORT).show()
                }
            }
        })
}

@Composable
fun PruebaView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getPruebas()) { prueba ->
            ItemPrueba(pruebas = prueba) {
                Toast.makeText(context, it.Name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemPrueba(pruebas: Pruebas, onItemSelected: (Pruebas) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(pruebas) })
    {
        Column() {
            Image(
                painter = painterResource(id = pruebas.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = pruebas.Name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = pruebas.Enlace,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
        }
    }
}

fun getPruebas(): List<Pruebas> {
    return listOf(
        Pruebas("Abdominales", "", R.drawable.abdominales),
        Pruebas("Flexibilidad", "", R.drawable.flexibilidad),
        Pruebas("Test Cooper", "", R.drawable.testdecooper),
        Pruebas("Velocidad 5 x 10", "", R.drawable.p5x10),
        Pruebas("Lanzar Balon", "", R.drawable.balon)
    )
}