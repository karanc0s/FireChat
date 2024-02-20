package com.karan.firechat.ui.screen.auth

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.karan.firechat.ui.common.EmailOutlineField
import com.karan.firechat.ui.common.PasswordOutlineField
import com.karan.firechat.ui.navigation.SignUpScreen
import com.karan.firechat.utils.showToast

@Composable
fun AuthView(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val viewState by authViewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current

    var textEmail: String by remember { mutableStateOf("") }
    var textPassword: String by remember { mutableStateOf("") }
    Log.e("TAG", "AuthView: outer", )

    with(viewState){
        Log.e("TAG", "AuthVidfgdew: ", )
        when(this){
            is AuthScreenState.Error -> context.showToast(this.message)
            is AuthScreenState.Success<*> -> context.showToast(this.data.toString())
            AuthScreenState.Initial -> context.showToast("Initial")
            AuthScreenState.Loading -> context.showToast("loading")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        EmailOutlineField(value = { textEmail}, hint = "Email", icon = Icons.Default.Email){
            textEmail = it
        }
        Spacer(modifier = Modifier.height(15.dp))
        PasswordOutlineField(value = { textPassword }, hint = "Password", icon = Icons.Default.Lock){
            textPassword = it
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {authViewModel.signIn(email = textEmail, pass = textPassword)}) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {
            navHostController.navigate(route = SignUpScreen.route)
        }) {
            Text(text = "Create Account")
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {}) {
            Text(text = "Google SignIn")
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AuthPrev() {
//    AuthView()
}

