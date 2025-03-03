package com.example.baremoeurofitpablomolina.navigation

import androidx.annotation.DrawableRes

data class Pruebas(
    val name: String,
    val descripcion: String,
    val imagen: Int,
    val categorias: List<Categoria> // Ahora puede tener varias categorías
)


enum class Categoria {
    FUERZA, FLEXIBILIDAD, VELOCIDAD, AGILIDAD, COORDINACION, RESISTENCIA
}
