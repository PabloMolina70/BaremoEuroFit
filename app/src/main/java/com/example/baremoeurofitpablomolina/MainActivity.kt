package com.example.baremoeurofitpablomolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baremoeurofitpablomolina.navigation.MyDialog
import com.example.baremoeurofitpablomolina.navigation.MyScreen
import com.example.baremoeurofitpablomolina.navigation.NavigationWrape
import com.example.baremoeurofitpablomolina.navigation.PruebasGridView
import com.example.baremoeurofitpablomolina.navigation.PruebasStickyView
import com.example.baremoeurofitpablomolina.navigation.PruebasWithSpecialControl
import com.example.baremoeurofitpablomolina.ui.theme.BaremoEuroFitPabloMolinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWrape()
        }
    }
}