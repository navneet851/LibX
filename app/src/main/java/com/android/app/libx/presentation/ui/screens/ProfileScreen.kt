package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.ui.components.AppButton
import com.android.app.libx.presentation.ui.components.BorrowedBookTemplate
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.viewmodel.AuthViewmodel

@Preview
@Composable
fun ProfileScreen() {
    val authViewModel: AuthViewmodel = hiltViewModel()
    val user by authViewModel.user.collectAsState()

    LaunchedEffect(key1 = Unit) {
        authViewModel.getUser()
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        when (user) {
            is Response.Loading -> {
                Loader()
            }

            is Response.Success -> {
//                Text(
//                    text = (user as Response.Success).data.user.toString(),
//                    color = Color.White
//                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Navneet Yadav",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color.DarkGray)
                            .padding(8.dp, 1.dp),
                        text = "Admin",
                        fontSize = 13.sp,
                        color = Color.LightGray
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color.DarkGray)
                            .padding(5.dp)
                            .size(20.dp),
                        imageVector = Icons.Rounded.Email,
                        contentDescription = "mail",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(
                        text = "nav700neet@gmail.com",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        letterSpacing = 0.sp,
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(30))
                        .background(Color.DarkGray)
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Borrowed Books",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.LightGray
                )
                HorizontalDivider()
                LazyColumn(
                    modifier = Modifier.height(30.dp)
                ) {
                    items(5){
                        BorrowedBookTemplate()
                    }
                }

                AppButton(
                    modifier = Modifier
                        .height(38.dp)
                        .border(Dp.Hairline, Color.LightGray, RoundedCornerShape(19.dp))
                    ,
                    text = "Log Out",
                    buttonColor = Color.Transparent,
                    textColor = Color.LightGray
                ) {

                }
            }

            is Response.Error -> {
                Text((user as Response.Error).error.uppercase())
            }
        }
        Text("Welcome Admin")
    }
}