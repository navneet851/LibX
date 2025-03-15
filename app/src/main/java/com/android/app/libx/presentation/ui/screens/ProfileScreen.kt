package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.viewmodel.AuthViewmodel

@Preview
@Composable
fun ProfileScreen() {
    val authViewModel : AuthViewmodel = hiltViewModel()
    val user by authViewModel.user.collectAsState()

    LaunchedEffect(key1 = Unit){
        authViewModel.getUser()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        when(user){
            is Response.Loading -> {
                Loader()
            }
            is Response.Success -> {
                Text(
                    text = (user as Response.Success).data.user.toString(),
                    color = Color.White
                )
            }
            is Response.Error -> {
                Text((user as Response.Error).error.uppercase())
            }
        }
        Text("Welcome Admin")
    }
}