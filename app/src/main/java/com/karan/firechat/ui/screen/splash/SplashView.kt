package com.karan.firechat.ui.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.karan.firechat.ui.navigation.AuthScreen
import com.karan.firechat.ui.navigation.Screen
import com.karan.firechat.ui.navigation.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun SplashView(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = true) {
        delay(timeMillis = 3000)

        // with shared preferences
        // if user logged in move to home
        // else move to auth screen
        navHostController.navigate(route = AuthScreen.route){
            navHostController.popBackStack(route = SplashScreen.route , inclusive = true)
        }

    }

    Box(modifier = modifier.fillMaxSize()){
        Icon(imageVector = Icons.Default.MailOutline, contentDescription = "" )
    }
}


@Preview(showBackground = true , showSystemUi = true)
@Composable
private fun SplashPrev() {
    SplashView(navHostController = rememberNavController())
}




