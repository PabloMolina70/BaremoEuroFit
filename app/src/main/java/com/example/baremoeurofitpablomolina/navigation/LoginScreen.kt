package com.example.baremoeurofitpablomolina.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(navigateToHome: () -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.8f))
        Text(text = "Bienvenido ", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Correo Electronico ", fontSize = 15.sp)
        TextField(value = text, onValueChange = { text = it })
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Contraseña ", fontSize = 15.sp)
        TextField(value = text, onValueChange = { text = it })
        Spacer(modifier = Modifier.weight(0.2f))
        Button(onClick = { navigateToHome() }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin(){
    val navControler = rememberNavController()
    LoginScreen(navigateToHome = { navControler.navigate(Home) })
}