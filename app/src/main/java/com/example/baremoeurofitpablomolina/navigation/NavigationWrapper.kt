package com.example.baremoeurofitpablomolina.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import kotlin.reflect.typeOf

@Composable
fun NavigationWrape() {
    // Se crea un controlador de navegación que recordará la navegación entre pantallas
    val navControler = rememberNavController()

    // Se define el NavHost que maneja la navegación entre pantallas, con la pantalla de inicio establecida como 'Login'
    NavHost(navController = navControler, startDestination = Login) {
        // Composable para la pantalla de login
        composable<Login> {
            // Llama a la función LoginScreen y pasa la función para navegar a la pantalla de datos
            LoginScreen(navigateToData = { navControler.navigate(Data) })
        }

        // Composable para la pantalla de datos
        composable<Data> {
            // Llama a la función DataScreen y pasa la función para navegar a la pantalla del reciclerView
            DataScreen(navigateToRecicler = { navControler.navigate(Recicler) })
        }

        // Composable para la pantalla de reciclaje
        composable<Recicler> {
            // Llama a la función ReciclerViewScreen
            ReciclerViewScreen()
        }
    }
}


