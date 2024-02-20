package com.karan.firechat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karan.firechat.ui.screen.auth.AuthView
import com.karan.firechat.ui.screen.auth.SignUpView
import com.karan.firechat.ui.screen.splash.SplashView

@Composable
fun AppNavigation( navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = SplashScreen.route){

        composable(route = SplashScreen.route){
            SplashView(navHostController = navHostController)
        }

        composable(route = AuthScreen.route){
            AuthView(navHostController = navHostController)
        }

        composable(route = SignUpScreen.route){
            SignUpView(navHostController = navHostController)
        }

        composable(route = HomeScreen.route){

        }

    }

}