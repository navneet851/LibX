package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.ui.components.AppTextField
import com.android.app.libx.presentation.ui.components.BookTemplate
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.ui.components.UserTemplate
import com.android.app.libx.presentation.viewmodel.AdminViewModel

@Preview
@Composable
fun AdminScreen() {
    val adminViewModel: AdminViewModel = hiltViewModel()
    val usersResponse by adminViewModel.users.collectAsState()

    LazyColumn(
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        when (usersResponse) {
            is Response.Loading -> {
                item {
                    Loader()

                }
            }

            is Response.Success -> {
                val users = (usersResponse as Response.Success).data.users
                items(users.size) {
                    UserTemplate(users[it])
                }
            }

            is Response.Error -> {
                item {
                    Text((usersResponse as Response.Error).error.uppercase())

                }
            }
        }
    }
}