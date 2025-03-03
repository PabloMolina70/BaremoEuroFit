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
    val navControler = rememberNavController()
    NavHost(navController = navControler, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToData = { navControler.navigate(Data) })
        }
        composable<Data> {
            DataScreen (navigateToRecicler = { navControler.navigate(Recicler) })
        }
        composable<Recicler> {
             ReciclerViewScreen(navControler)
        }
    }
}

