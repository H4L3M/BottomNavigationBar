package com.example.bottomnavigationbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigationbar.ui.nav.*
import com.example.bottomnavigationbar.ui.screens.Screen
import com.example.bottomnavigationbar.ui.theme.BottomNavigationBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavApp() {
    val navController = rememberNavController()

    BottomNavigationBarTheme {
        Scaffold(
            bottomBar = {
                NavBar(navController = navController)
            }
        ) { paddingValues ->

            Column(modifier = Modifier.padding(paddingValues = paddingValues)) {

                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                    screens.forEach { screen ->
                        composable(route = screen.route) { screen.content.invoke()}
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun Prev() {
    NavApp()
}