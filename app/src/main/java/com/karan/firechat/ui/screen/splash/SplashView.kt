package com.karan.firechat.ui.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.karan.firechat.ui.navigation.AuthScreen
import com.karan.firechat.ui.navigation.BottomNavScreen
import com.karan.firechat.ui.navigation.Screen
import com.karan.firechat.ui.navigation.SplashScreen
import com.karan.firechat.utils.PrefsKeys
import com.karan.firechat.utils.getPrefs
import kotlinx.coroutines.delay

@Composable
fun SplashView(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        delay(timeMillis = 3000)

        // with shared preferences
        // if user logged in move to home
        // else move to auth screen

        val route: String = if(context.getPrefs().getBoolean(PrefsKeys.KEY_IS_LOGGED_IN , false)){
            BottomNavScreen.route
        }else{
            AuthScreen.route
        }


        navHostController.navigate(route = route){
            navHostController.popBackStack(route = SplashScreen.route , inclusive = true)
        }

    }

    Box(modifier = modifier.fillMaxSize()){
        Icon(imageVector = Icons.Default.MailOutline, contentDescription = "" )
    }
}





