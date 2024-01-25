package com.example.deliciousandy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deliciousandy.ui.scenes.AddScene
import com.example.deliciousandy.ui.scenes.home.HomeScene

@Composable
fun DeliciousNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Scenes.HOME.name
    ) {
        composable(route = Scenes.HOME.name) {
            HomeScene()
        }
        composable(route = Scenes.ADD_RECIPE.name) {
            AddScene(
                onExit = { navController.navigate(Scenes.HOME.name) {
                    launchSingleTop = true
                } },
            )
        }
    }
}
