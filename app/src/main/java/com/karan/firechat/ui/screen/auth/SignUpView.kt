package com.karan.firechat.ui.screen.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.karan.firechat.ui.common.CustomOutlineField
import com.karan.firechat.ui.common.EmailOutlineField

@Composable
fun SignUpView(
    modifier: Modifier = Modifier ,
    navHostController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel()
) {

    var firstNameText by remember { mutableStateOf("") }
    var lastNameText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()){

        Column {
            Row {
                CustomOutlineField(value = { firstNameText}, hint = "First Name",){ firstNameText = it }
                CustomOutlineField(value = { lastNameText}, hint = "Last Name",){ lastNameText = it }
            }
            EmailOutlineField(value = { emailText }, hint ="Email", icon = Icons.Default.Email){
                emailText = it
            }

        }

    }

}