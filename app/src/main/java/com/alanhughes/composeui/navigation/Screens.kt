package com.alanhughes.composeui.navigation

sealed class Screen(val route: String) {
    object LandingScreen: Screen("landing")
    object CanvasScreen: Screen("canvas")
}
