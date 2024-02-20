package com.karan.firechat.ui.navigation

sealed class Screen(val route : String ){}

data object SplashScreen : Screen("splash")
data object AuthScreen : Screen("auth")

data object SignUpScreen : Screen ("signUpS")

data object HomeScreen : Screen("home")


