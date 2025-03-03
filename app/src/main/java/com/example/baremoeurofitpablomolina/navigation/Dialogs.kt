package com.example.baremoeurofitpablomolina.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit,altura:Double,peso:Int){
    if(show){
        AlertDialog(
            onDismissRequest = {onDismiss()},
            confirmButton = {
                TextButton(onClick = {onConfirm()}) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = {onDismiss()}) {
                    Text(text = "DismissButton")
                }
            },
            title = { Text(text = "IMC") },
            text = { Text(text = "Tu IMC es "+(peso/(altura*altura))) }
        )
    }
}