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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baremoeurofitpablomolina.R

// Función principal que muestra la pantalla de reciclaje con las pruebas organizadas por categoría
@OptIn(ExperimentalFoundationApi::class) // Se usa para habilitar el uso de API experimentales de Jetpack Compose
@Composable
fun ReciclerViewScreen() {
    // Obtiene la lista de pruebas a mostrar
    val pruebas = getPruebas()

    // Obtiene el contexto actual (para mostrar Toasts)
    val context = LocalContext.current

    // Organiza las pruebas por categoría utilizando un mapa, donde la clave es la categoría y el valor es una lista de pruebas
    val pruebasPorCategoria: Map<Categoria, List<Pruebas>> = Categoria.values().associateWith { categoria ->
        pruebas.filter { it.categorias.contains(categoria) }
    }

    // Lista perezosa (LazyColumn) que organiza las pruebas por categoría
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Itera sobre cada categoría y sus pruebas correspondientes
        pruebasPorCategoria.forEach { (categoria, pruebas) ->
            if (pruebas.isNotEmpty()) {
                // Header fijo para cada categoría (stickyHeader)
                stickyHeader {
                    Text(
                        text = categoria.name, // Muestra el nombre de la categoría
                        modifier = Modifier
                            .fillMaxWidth() // Hace que el texto ocupe todo el ancho disponible
                            .background(Color.Red), // Fondo rojo para el encabezado
                        color = Color.Black, // Color del texto en negro
                        fontSize = 26.sp // Tamaño de fuente grande
                    )
                }
                // Muestra cada prueba en la lista
                items(pruebas) { prueba ->
                    // Componente que muestra cada prueba individual
                    ItemPrueba(pruebas = prueba) {
                        // Al hacer clic en una prueba, muestra un Toast con el nombre de la prueba seleccionada
                        Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

// Componente que muestra cada prueba individual dentro de una tarjeta
@Composable
fun ItemPrueba(pruebas: Pruebas, onItemSelected: (Pruebas) -> Unit) {
    // Crea una tarjeta con borde rojo que muestra la imagen, nombre y descripción de la prueba
    Card(
        border = BorderStroke(2.dp, Color.Red), // Borde rojo
        modifier = Modifier
            .width(200.dp) // Ancho fijo de la tarjeta
            .clickable { onItemSelected(pruebas) }) // Acción al hacer clic
    {
        Column() {
            // Imagen de la prueba
            Image(
                painter = painterResource(id = pruebas.imagen), // Imagen asociada a la prueba
                contentDescription = "Foto ejercicio", // Descripción para accesibilidad
                modifier = Modifier.fillMaxWidth(), // La imagen ocupa todo el ancho de la tarjeta
                contentScale = ContentScale.Crop // Recorta la imagen para mantener su proporción
            )
            // Nombre de la prueba
            Text(
                text = pruebas.name,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Centra el texto horizontalmente
            )
            // Descripción de la prueba
            Text(
                text = pruebas.descripcion,
                modifier = Modifier.align(Alignment.CenterHorizontally), // Centra el texto
                fontSize = 12.sp // Tamaño de fuente pequeño
            )
        }
    }
}

// Función que retorna una lista de pruebas con diferentes categorías
fun getPruebas(): List<Pruebas> {
    return listOf(
        // Cada prueba tiene un nombre, descripción, imagen (referencia a recurso) y categorías
        Pruebas("Abdominales", "", R.drawable.abdominales, listOf(Categoria.FUERZA, Categoria.RESISTENCIA)),
        Pruebas("Flexibilidad", "", R.drawable.flexibilidad, listOf(Categoria.FLEXIBILIDAD)),
        Pruebas("Test Cooper", "", R.drawable.testdecooper, listOf(Categoria.RESISTENCIA, Categoria.VELOCIDAD)),
        Pruebas("Velocidad 5 x 10", "", R.drawable.p5x10, listOf(Categoria.VELOCIDAD, Categoria.AGILIDAD)),
        Pruebas("Lanzar Balón", "", R.drawable.balon, listOf(Categoria.COORDINACION, Categoria.FUERZA))
    )
}
