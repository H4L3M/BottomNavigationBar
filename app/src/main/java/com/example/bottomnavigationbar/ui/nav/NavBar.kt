package com.example.bottomnavigationbar.ui.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigationbar.ui.screens.Screen


val screens = listOf(
    Screen.HomeScreen,
    Screen.FavoriteScreen,
    Screen.SearchScreen
)

@Composable
fun NavBar(navController: NavController) {

    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        screens.forEach { screen ->

            NavigationBarItem(
                label = { Text(text = screen.route) },
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }

    }

}

@Preview(name = "Bottom Navigation Bar")
@Composable
fun Prev() {
    NavBar(navController = rememberNavController())
}