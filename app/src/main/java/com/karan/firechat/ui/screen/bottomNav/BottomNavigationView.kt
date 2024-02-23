package com.karan.firechat.ui.screen.bottomNav

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationView(navHostController: NavHostController) {


    val tabs = listOf(
        Chat,
        Explore,
        Profile
    )
    var currentTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed{ index , item ->
                    NavigationBarItem(
                        selected = currentTabIndex == index,
                        onClick = {
                            currentTabIndex = index
                            navHostController.navigate(route = item.route)
                        },
                        icon = {
                            BadgedBox(badge = {}) {
                                Icon(
                                    imageVector = if(currentTabIndex == index) item.selectedIcon else item.unSelectedIcon,
                                    contentDescription = ""
                                )
                            }
                        }
                    )
                }
            }
        }
    ){pading ->
    }
}