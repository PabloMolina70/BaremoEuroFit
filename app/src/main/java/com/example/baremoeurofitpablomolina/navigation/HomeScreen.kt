package com.example.baremoeurofitpablomolina.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navigateToRecicler: () -> Unit) {
    var edad by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var option1 by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    var option2 by rememberSaveable { mutableStateOf(ToggleableState.On) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Datos ", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Edad ", fontSize = 15.sp)
        TextField(value = edad, onValueChange = { edad = it })
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Peso ", fontSize = 15.sp)
        TextField(value = peso, onValueChange = { peso = it })
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Altura ", fontSize = 15.sp)
        TextField(value = altura, onValueChange = { altura = it })
        Spacer(modifier = Modifier.weight(0.2f))
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = option1, onClick = {
                option1 = when (option1) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
                if (option1 == ToggleableState.On) {
                    option2 = ToggleableState.Off
                }
            })
            Text(text = "Chico")
        }

        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = option2, onClick = {
                option2 = when (option2) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
                if (option2 == ToggleableState.On) {
                    option1 = ToggleableState.Off
                }
            })
            Text(text = "Chica")
        }
        Button(onClick = { navigateToRecicler() }) {
            Text(text = "Confirmar")
        }
        Row {
            var enviarAltura = 0.0
            var enviarPeso = 0
            if (altura != "") {
                enviarAltura = altura.toDouble()
            } else {
                enviarAltura = 0.0
            }
            if (peso != "") {
                enviarPeso = peso.toInt()
            } else {
                enviarPeso = 0
            }
            MyIMC("IMC", altura = enviarAltura, peso = enviarPeso)
            Button(onClick = {}) {
                Text(text = "Ver Notas")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun MyIMC(texto: String, altura: Double, peso: Int) {
    var showDialog by remember { mutableStateOf(false) }
    fun showDialogOnClick() {
        showDialog = true
    }

    fun dismissDialog() {
        showDialog = false
    }

    fun confirmDialog() {
        showDialog = false
    }
    Button(onClick = { showDialogOnClick() }) {
        Text(text = texto)
    }

    MyDialog(
        show = showDialog,
        onDismiss = { dismissDialog() },
        onConfirm = { confirmDialog() },
        altura = altura,
        peso = peso
    )

}

