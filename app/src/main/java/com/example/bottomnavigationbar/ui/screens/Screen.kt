package com.example.bottomnavigationbar.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    object HomeScreen : Screen(route = "Home", icon = Icons.Rounded.Home)
    object FavoriteScreen : Screen(route = "Favorite", icon = Icons.Rounded.Favorite)
    object SearchScreen : Screen(route = "Search", icon = Icons.Rounded.Search)


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