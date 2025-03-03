package com.example.baremoeurofitpablomolina.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlin.reflect.typeOf

@Composable
fun NavigationWrape() {
    val navControler = rememberNavController()
    NavHost(navController = navControler, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToHome = { navControler.navigate(Home) })
        }
        composable<Home> {
            HomeScreen (navigateToRecicler = { navControler.navigate(Recicler) })
        }
        composable<Recicler> {
             ReciclerViewScreen(navControler)
        }
    }
}
