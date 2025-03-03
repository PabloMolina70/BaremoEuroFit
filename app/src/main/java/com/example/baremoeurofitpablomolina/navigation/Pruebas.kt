package com.example.baremoeurofitpablomolina.navigation

// Clase de datos que representa una prueba con su nombre, descripción, imagen y categorías asociadas
data class Pruebas(
    val name: String, // Nombre de la prueba
    val descripcion: String, // Descripción de la prueba
    val imagen: Int, // Imagen de la Prueba
    val categorias: List<Categoria>, // Lista de categorías de esta prueba
)

// Enumeración que representa las diferentes categorías de ejercicios
enum class Categoria {
    FUERZA,        // Categoria para ejercicios de fuerza
    FLEXIBILIDAD,  // Categoria para ejercicios de flexibilidad
    VELOCIDAD,     // Categoria para ejercicios de velocidad
    AGILIDAD,      // Categoria para ejercicios de agilidad
    COORDINACION,  // Categoria para ejercicios de coordinación
    RESISTENCIA    // Categoria para ejercicios de resistencia
}

