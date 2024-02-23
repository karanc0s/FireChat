package com.karan.firechat.ui.screen.auth

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.karan.firechat.ui.common.CustomOutlineField
import com.karan.firechat.ui.common.EmailOutlineField
import com.karan.firechat.ui.common.PasswordOutlineField
import com.karan.firechat.utils.showToast

@Composable
fun SignUpView(
    modifier: Modifier = Modifier ,
    navHostController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel()
) {




    var firstNameText by rememberSaveable { mutableStateOf("") }
    var lastNameText by rememberSaveable { mutableStateOf("") }
    var emailText by rememberSaveable { mutableStateOf("") }
    var passText by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()){

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Icon(
                modifier = Modifier.size(70.dp),
                imageVector = Icons.Default.PersonAddAlt1,
                contentDescription = "" ,
                )
            Spacer(modifier = Modifier.weight(0.06F))
            Row {
                CustomOutlineField(
                    modifier = Modifier
                        .weight(0.1F)
                        .padding(horizontal = 10.dp),
                    value = { firstNameText},
                    hint = "First Name"
                ){
                    firstNameText = it
                }
                CustomOutlineField(
                    modifier = Modifier
                        .weight(0.1F)
                        .padding(horizontal = 10.dp),
                    value = { lastNameText},
                    hint = "Last Name"
                ){
                    lastNameText = it
                }
            }
            EmailOutlineField(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth(),
                value = { emailText },
                hint ="Email",
                icon = Icons.Default.Email
            ){
                emailText = it
            }

            PasswordOutlineField(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth(),
                value = {passText},
                hint = "********",
                icon = Icons.Default.Password
            ){
                passText = it
            }

            Spacer(modifier = Modifier.weight(0.3F))

            Button(
                onClick = {

                }
            ) {
                Text(text = "Create Account")
            }
            Spacer(modifier = Modifier.height(20.dp))

        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Prev1() {
    SignUpView(navHostController = rememberNavController())
}