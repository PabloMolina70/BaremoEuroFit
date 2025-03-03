package com.example.baremoeurofitpablomolina.navigation


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    altura: Double,
    peso: Int
) {
    var calcularAltura = 0.0
    if (altura > 100) {
        calcularAltura = altura / 100
    }else{
        calcularAltura = altura
    }
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            },
            title = { Text(text = "IMC") },
            text = { Text(text = "Tu IMC es " + (peso / (calcularAltura * calcularAltura))) }
        )
    }
}