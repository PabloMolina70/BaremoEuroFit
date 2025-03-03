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
fun LoginScreen(navigateToHome: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.8f))
        Text(text = "Bienvenido", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Correo Electrónico", fontSize = 15.sp)
        TextField(value = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Contraseña", fontSize = 15.sp)
        TextField(value = password, onValueChange = { password = it })
        Spacer(modifier = Modifier.weight(0.2f))
        
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }

        Button(onClick = {
            if (validateUser(email, password)) {
                navigateToHome()
            } else {
                errorMessage = "Credenciales incorrectas"
            }
        }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

fun validateUser(email: String, password: String): Boolean {
    return email == "user@pablo.com" && password == "1234"
}