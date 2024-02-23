package com.karan.firechat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karan.firechat.ui.screen.auth.AuthView
import com.karan.firechat.ui.screen.auth.SignUpView
import com.karan.firechat.ui.screen.bottomNav.BottomNavigationView
import com.karan.firechat.ui.screen.splash.SplashView
import com.karan.firechat.ui.screen.tabChats.TabChatsView
import com.karan.firechat.ui.screen.tabExplore.TabExploreView
import com.karan.firechat.ui.screen.tabProfile.TabProfileView

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


        composable(route = BottomNavScreen.route){
            BottomNavigationView(navHostController = navHostController)
        }

        composable(route = TabChats.route){
            TabChatsView(navHostController = navHostController)
        }
        composable(route = TabExplore.route){
            TabExploreView(navHostController = navHostController)
        }
        composable(route = TabProfile.route){
            TabProfileView(navHostController = navHostController)
        }

    }

}