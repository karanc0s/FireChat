package com.karan.firechat.ui.screen.tabs.tabChats


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.karan.firechat.ui.common.CustomOutlineField
import com.karan.firechat.ui.theme.Purple80

@Composable
fun TabChatsView(navHostController: NavHostController) {
    val viewModel : TabChatsViewModel = hiltViewModel()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
    ){

        SearchField()

        


    }

}


@Composable
fun SearchField() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
           ,
        value = text ,
        onValueChange = {text = it},
        placeholder = {
            Text("Search")
        },
        prefix = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "")
        },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done), // keyboard options
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor  = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp)
    )
}





@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ChatsPrev() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)) {
        SearchField()
    }
}