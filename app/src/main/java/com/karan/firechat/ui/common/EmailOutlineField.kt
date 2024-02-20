package com.karan.firechat.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun EmailOutlineField(
    value : ()-> String,
    hint: String,
    icon: ImageVector,
    onChange: (String) -> Unit = {}
) {


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value(),
        label = { Text(text = hint) },
        onValueChange = onChange,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        }
    )
}