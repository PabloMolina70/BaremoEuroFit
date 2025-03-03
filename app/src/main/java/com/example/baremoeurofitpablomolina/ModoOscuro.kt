package com.example.baremoeurofitpablomolina

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Composable que muestra un interruptor (Switch) para cambiar entre modo claro y oscuro.
 *
 * @param themeViewModel ViewModel encargado de gestionar el estado del tema.
 */
@Composable
fun NavigationWrape(themeViewModel: ThemeViewModel) {
    // Estado local para reflejar el estado del tema
    var isDark by remember { mutableStateOf(themeViewModel.isDark) }

    Column {
        Spacer(modifier = Modifier.height(30.dp)) // Espaciador para separar elementos
        Switch(
            checked = isDark,
            onCheckedChange = {
                themeViewModel.toggleTheme() // Cambia el estado del tema
                isDark = themeViewModel.isDark // Actualiza el estado local
            }
        )
    }
}

/**
 * ViewModel encargado de manejar el estado del tema (claro/oscuro).
 */
class ThemeViewModel : ViewModel() {
    // Estado que indica si el tema actual es oscuro
    var isDark by mutableStateOf(false)
        private set

    /**
     * Alterna entre el modo claro y oscuro.
     */
    fun toggleTheme() {
        isDark = !isDark
    }
}

/**
 * Composable principal de la aplicación que gestiona el tema y la interfaz de usuario.
 *
 * @param themeViewModel ViewModel encargado del estado del tema. Se obtiene con [viewModel()] por defecto.
 */
@Composable
fun MyApp(themeViewModel: ThemeViewModel = viewModel()) {
    // Estado derivado para reaccionar a cambios en el tema
    val isDarkMode by remember { derivedStateOf { themeViewModel.isDark } }

    MaterialTheme(
        colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavigationWrape(themeViewModel) // Renderiza la UI con el switch para cambiar de tema
        }
    }
}
