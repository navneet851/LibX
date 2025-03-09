package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.app.libx.R
import com.android.app.libx.presentation.ui.components.AppButton
import com.android.app.libx.presentation.ui.components.AppTextField
import com.android.app.libx.presentation.ui.components.PassTextField
import com.android.app.libx.ui.theme.BlackShaded

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
            ,
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo"
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Log in to LibX",
            fontWeight = FontWeight.Medium,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))
        
        AppTextField(
            text = email,
            placeholder = "Email"
        ){
            email = it
        }
        Spacer(modifier = Modifier.height(10.dp))

        PassTextField(
            password
        ){
            password = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        AppButton(
            text = "Sign in"
        ){

        }

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(
            modifier = Modifier.width(200.dp),
            text = "forget password?",
            textColor = Color.White,
            buttonColor = BlackShaded
        ){

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "new user",
            color = BlackShaded
        )
    }
}