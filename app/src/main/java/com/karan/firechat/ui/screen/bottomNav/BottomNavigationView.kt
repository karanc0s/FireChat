package com.karan.firechat.ui.screen.bottomNav

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
@Composable

fun BottomNavigationView() {

    val bottomNavController = rememberNavController()
    val currentBackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentTab = currentBackEntry?.destination
    val tabs = listOf(Chat, Explore, Profile)


    BackHandler(enabled = true) {}

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach{   item ->
                    NavigationBarItem(
                        selected = currentTab?.route == item.route,
                        onClick = {
                            bottomNavController.navigate(item.route){
                                popUpTo(bottomNavController.graph.findStartDestination().id){}
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            BadgedBox(badge = {}) {
                                Icon(
                                    imageVector = if(currentTab?.route == item.route) item.selectedIcon else item.unSelectedIcon,
                                    contentDescription = ""
                                )
                            }
                        }
                    )
                }
            }
        }
    ){
        Box(modifier = Modifier.padding(it)){
            BottomNavGraph(navHostController = bottomNavController)
        }

    }
}