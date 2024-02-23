package com.karan.firechat.ui.screen.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.MarkUnreadChatAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.karan.firechat.ui.navigation.TabChats
import com.karan.firechat.ui.navigation.TabExplore
import com.karan.firechat.ui.navigation.TabProfile

sealed class BottomNavItem(
    val title : String ,
    val route : String,
    val selectedIcon : ImageVector,
    val unSelectedIcon : ImageVector,
    val hasUpdate : Boolean,
    val badgeCount : Int? = null,
)


data object Chat : BottomNavItem(
    title = "Chats",
    route = TabChats.route,
    selectedIcon = Icons.AutoMirrored.Filled.Chat,
    unSelectedIcon = Icons.AutoMirrored.Outlined.Chat,
    hasUpdate = false
)


data object Explore : BottomNavItem(
    title = "Explore",
    route = TabExplore.route,
    selectedIcon = Icons.Filled.Explore,
    unSelectedIcon = Icons.Outlined.Explore,
    hasUpdate = false
)


data object Profile : BottomNavItem(
    title = "Profile",
    route = TabProfile.route,
    selectedIcon =  Icons.Filled.Person,
    unSelectedIcon =  Icons.Outlined.Person,
    hasUpdate = false
)





