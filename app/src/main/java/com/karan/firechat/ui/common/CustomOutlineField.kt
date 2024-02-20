package com.karan.firechat.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomOutlineField(

    value : ()-> String,
    hint: String,
    onChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value(),
        label = { Text(text = hint) },
        onValueChange = onChange,

    )
}