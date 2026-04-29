package me.davidangarita.exploraapp.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(onClickAddTouristicPlace : ()-> Unit = {}) {
    Scaffold(topBar = {
        TopAppBar(title = {Text("Explora Colombia")})
    },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onClickAddTouristicPlace()

            }) {
                Icon(Icons.Default.Add, contentDescription = null)

            }
        }


    ){innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {  }
    }
}