package com.karan.firechat.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordOutlineField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    value: () -> String,
    hint: String,
    icon: ImageVector,
    onChange: (String) -> Unit = {}
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = value(),
        label = { Text(hint) },
        onValueChange = onChange,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff


            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(imageVector = image, "")
            }
        }
    )
}

