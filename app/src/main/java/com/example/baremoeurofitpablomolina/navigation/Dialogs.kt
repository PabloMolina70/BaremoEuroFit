package com.example.baremoeurofitpablomolina.navigation


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(
    show: Boolean, // Estado que controla la visibilidad del cuadro de diálogo
    onDismiss: () -> Unit, // Función que se llama al cerrar el diálogo sin confirmar
    onConfirm: () -> Unit, // Función que se llama al confirmar la acción
    altura: Double, // Altura proporcionada por el usuario
    peso: Int // Peso proporcionado por el usuario
) {
    // Cálculo de la altura en metros (si la altura está en centímetros, se divide entre 100)
    var calcularAltura = 0.0
    if (altura > 100) {
        calcularAltura = altura / 100
    } else {
        calcularAltura = altura
    }

    // Si el estado 'show' es verdadero, muestra el cuadro de diálogo
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() }, // Acción cuando se solicita cerrar el diálogo
            confirmButton = {
                // Botón de confirmación que ejecuta la función 'onConfirm' al hacer clic
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton") // Texto en el botón de confirmación
                }
            },
            dismissButton = {
                // Botón de cancelación que ejecuta la función 'onDismiss' al hacer clic
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton") // Texto en el botón de cancelación
                }
            },
            title = { Text(text = "IMC") }, // Título del cuadro de diálogo
            text = {
                // Cálculo y texto que muestra el IMC basado en el peso y la altura
                Text(text = "Tu IMC es " + (peso / (calcularAltura * calcularAltura)))
            }
        )
    }
}
