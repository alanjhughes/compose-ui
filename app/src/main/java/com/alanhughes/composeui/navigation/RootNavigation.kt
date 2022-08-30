package com.alanhughes.composeui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alanhughes.composeui.ui.screens.canvas.CanvasScreen
import com.alanhughes.composeui.ui.screens.landing.LandingScreen

@Composable
fun RootNavigation(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = Screen.LandingScreen.route) {
        composable(Screen.LandingScreen.route) {
            LandingScreen {
                navController.navigate(it)
            }
        }
        composable(Screen.CanvasScreen.route) {
            CanvasScreen()
        }
    }
}