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
fun DataScreen(navigateToRecicler: () -> Unit) {
    // Definición de las variables de estado para almacenar los datos introducidos por el usuario
    var edad by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var option1 by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    var option2 by rememberSaveable { mutableStateOf(ToggleableState.On) }

    // Contenedor principal de la pantalla con una columna de elementos
    Column(
        modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño disponible
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        Spacer(modifier = Modifier.weight(1f)) // Espaciador flexible en la parte superior
        Text(text = "Datos ", fontSize = 25.sp) // Título principal
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador entre los elementos
        Text(text = "Edad ", fontSize = 15.sp) // Etiqueta para el campo de edad
        TextField(value = edad, onValueChange = { edad = it }) // Campo de texto para la edad
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador
        Text(text = "Peso ", fontSize = 15.sp) // Etiqueta para el campo de peso
        TextField(value = peso, onValueChange = { peso = it }) // Campo de texto para el peso
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador
        Text(text = "Altura ", fontSize = 15.sp) // Etiqueta para el campo de altura
        TextField(value = altura, onValueChange = { altura = it }) // Campo de texto para la altura
        Spacer(modifier = Modifier.weight(0.2f)) // Espaciador

        // Fila para la selección del género (Chico)
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = option1, onClick = {
                // Lógica para cambiar el estado del primer checkbox
                option1 = when (option1) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
                // Si se selecciona "Chico", deselecciona "Chica"
                if (option1 == ToggleableState.On) {
                    option2 = ToggleableState.Off
                }
            })
            Text(text = "Chico") // Etiqueta para el checkbox "Chico"
        }

        // Fila para la selección del género (Chica)
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = option2, onClick = {
                // Lógica para cambiar el estado del segundo checkbox
                option2 = when (option2) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
                // Si se selecciona "Chica", deselecciona "Chico"
                if (option2 == ToggleableState.On) {
                    option1 = ToggleableState.Off
                }
            })
            Text(text = "Chica") // Etiqueta para el checkbox "Chica"
        }

        // Botón de confirmación que invoca la función navigateToRecicler
        Button(onClick = { navigateToRecicler() }) {
            Text(text = "Confirmar") // Texto del botón
        }

        // Cálculo del IMC y visualización de los valores de altura y peso
        Row {
            var enviarAltura = 0.0
            var enviarPeso = 0
            // Conversión de los valores de altura y peso a formato numérico
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
            MyIMC("IMC", altura = enviarAltura, peso = enviarPeso) // Llamada a la función MyIMC
            Button(onClick = {}) {
                Text(text = "Ver Notas") // Botón para mostrar notas
            }
        }
        Spacer(modifier = Modifier.weight(1f)) // Espaciador flexible en la parte inferior
    }
}

@Composable
fun MyIMC(texto: String, altura: Double, peso: Int) {
    // Variable de estado para mostrar u ocultar el cuadro de diálogo
    var showDialog by remember { mutableStateOf(false) }

    // Función para mostrar el cuadro de diálogo
    fun showDialogOnClick() {
        showDialog = true
    }

    // Función para cerrar el cuadro de diálogo sin hacer nada
    fun dismissDialog() {
        showDialog = false
    }

    // Función para confirmar la acción y cerrar el cuadro de diálogo
    fun confirmDialog() {
        showDialog = false
    }

    // Botón para mostrar el cuadro de diálogo con los detalles del IMC
    Button(onClick = { showDialogOnClick() }) {
        Text(text = texto) // Texto del botón
    }

    // Cuadro de diálogo que se muestra al hacer clic en el botón
    MyDialog(
        show = showDialog, // Estado de visibilidad del diálogo
        onDismiss = { dismissDialog() }, // Acción para cerrar el diálogo
        onConfirm = { confirmDialog() }, // Acción para confirmar y cerrar el diálogo
        altura = altura, // Altura para el cálculo del IMC
        peso = peso // Peso para el cálculo del IMC
    )
}


