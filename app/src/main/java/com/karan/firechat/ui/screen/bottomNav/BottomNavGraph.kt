package com.karan.firechat.ui.screen.bottomNav

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karan.firechat.ui.screen.tabChats.TabChatsView
import com.karan.firechat.ui.screen.tabExplore.TabExploreView
import com.karan.firechat.ui.screen.tabProfile.TabProfileView


@Composable
fun BottomNavGraph(navHostController: NavHostController) {


    NavHost(navController = navHostController, startDestination = Chat.route){

        composable(route = Chat.route){
            TabChatsView(navHostController = navHostController)
        }
        composable(route = Explore.route){
            TabExploreView(navHostController = navHostController)

        }
        composable(route = Profile.route){
            TabProfileView(navHostController = navHostController)

        }

    }

}