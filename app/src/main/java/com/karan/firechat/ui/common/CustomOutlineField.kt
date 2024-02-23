package com.karan.firechat.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomOutlineField(
    modifier: Modifier = Modifier,
    value : ()-> String,
    hint: String,
    onChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = value(),
        label = { Text(text = hint) },
        onValueChange = onChange,

    )
}