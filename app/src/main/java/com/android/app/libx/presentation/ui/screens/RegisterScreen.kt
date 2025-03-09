package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.app.libx.R
import com.android.app.libx.presentation.ui.components.AppTextField
import com.android.app.libx.presentation.ui.components.PassTextField

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun RegisterScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
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
            text = "Sign in to LibX",
            fontWeight = FontWeight.Medium,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(40.dp))


        AppTextField()
        Spacer(modifier = Modifier.height(10.dp))

        PassTextField()
    }
}