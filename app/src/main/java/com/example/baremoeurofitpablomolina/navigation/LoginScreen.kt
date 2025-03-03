package com.example.baremoeurofitpablomolina.navigation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateToData: () -> Unit) {
    // Variables de estado para almacenar el correo electrónico, la contraseña y el mensaje de error
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    // Contenedor principal de la pantalla con una columna de elementos
    Column(
        modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño disponible
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        Spacer(modifier = Modifier.weight(0.8f)) // Espaciador flexible en la parte superior
        Text(text = "Bienvenido", fontSize = 25.sp) // Título principal de bienvenida
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador entre los elementos
        Text(text = "Correo Electrónico", fontSize = 15.sp) // Etiqueta para el campo de correo electrónico
        TextField(value = email, onValueChange = { email = it }) // Campo de texto para el correo electrónico
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador
        Text(text = "Contraseña", fontSize = 15.sp) // Etiqueta para el campo de contraseña
        TextField(value = password, onValueChange = { password = it }) // Campo de texto para la contraseña
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador

        // Muestra un mensaje de error si las credenciales no son correctas
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red) // Mensaje de error en rojo
        }

        // Botón de login que valida las credenciales
        Button(onClick = {
            if (validateUser(email, password)) {
                // Si las credenciales son correctas, navega a la siguiente pantalla
                navigateToData()
            } else {
                // Si las credenciales son incorrectas, muestra un mensaje de error
                errorMessage = "Credenciales incorrectas"
            }
        }) {
            Text(text = "Login") // Texto del botón
        }
        Spacer(modifier = Modifier.weight(1f)) // Espaciador flexible en la parte inferior
    }
}

// Función que valida las credenciales del usuario
fun validateUser(email: String, password: String): Boolean {
    // Valida si el correo electrónico y la contraseña coinciden con las credenciales predefinidas
    return email == "user@pablo.com" && password == "1234"
}
