package com.example.bottomnavigationbar.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bottomnavigationbar.ui.nav.FavoriteScreen
import com.example.bottomnavigationbar.ui.nav.HomeScreen
import com.example.bottomnavigationbar.ui.nav.SearchScreen


typealias Content = @Composable () -> Unit

sealed class Screen(val route: String, val icon: ImageVector, val content: Content) {

    object HomeScreen : Screen(
        route = "Home",
        icon = Icons.Rounded.Home,
        content = { HomeScreen() }
    )

    object FavoriteScreen : Screen(
        route = "Favorite",
        icon = Icons.Rounded.Favorite,
        content = { FavoriteScreen() }
    )

    object SearchScreen : Screen(
        route = "Search",
        icon = Icons.Rounded.Search,
        content = { SearchScreen() }
    )

    //if you want to send values
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}