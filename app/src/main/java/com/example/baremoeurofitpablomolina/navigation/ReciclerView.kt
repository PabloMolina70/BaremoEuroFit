package com.example.baremoeurofitpablomolina.navigation

import android.net.Uri
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
import androidx.navigation.NavController
import com.example.baremoeurofitpablomolina.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReciclerViewScreen(navController: NavController) {
    val context = LocalContext.current
    val pruebas = getPruebas()

    val pruebasPorCategoria: Map<Categoria, List<Pruebas>> = Categoria.values().associateWith { categoria ->
        pruebas.filter { it.categorias.contains(categoria) }
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        pruebasPorCategoria.forEach { (categoria, pruebas) ->
            if (pruebas.isNotEmpty()) { // Evitar mostrar categorías sin pruebas
                stickyHeader {
                    Text(
                        text = categoria.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Green),
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                items(pruebas) { prueba ->
                    ItemPrueba(pruebas = prueba) {
                        navController.navigate("detalle/${Uri.encode(prueba.name)}")
                    }
                }
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
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            }
        })
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
                painter = painterResource(id = pruebas.imagen),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = pruebas.name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = pruebas.descripcion,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
        }
    }
}

fun getPruebas(): List<Pruebas> {
    return listOf(
        Pruebas("Abdominales", "", R.drawable.abdominales, listOf(Categoria.FUERZA, Categoria.RESISTENCIA)),
        Pruebas("Flexibilidad", "", R.drawable.flexibilidad, listOf(Categoria.FLEXIBILIDAD)),
        Pruebas("Test Cooper", "", R.drawable.testdecooper, listOf(Categoria.RESISTENCIA, Categoria.VELOCIDAD)),
        Pruebas("Velocidad 5 x 10", "", R.drawable.p5x10, listOf(Categoria.VELOCIDAD, Categoria.AGILIDAD)),
        Pruebas("Lanzar Balón", "", R.drawable.balon, listOf(Categoria.COORDINACION, Categoria.FUERZA))
    )
}