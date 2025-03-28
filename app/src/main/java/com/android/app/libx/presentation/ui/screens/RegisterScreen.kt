package com.android.app.libx.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.android.app.libx.R
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.register.VerifyOtp
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.navigation.Routes
import com.android.app.libx.presentation.ui.components.AppButton
import com.android.app.libx.presentation.ui.components.AppTextField
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.ui.components.PassTextField
import com.android.app.libx.presentation.ui.components.VerifyOtpBox
import com.android.app.libx.presentation.ui.theme.BlackShaded
import com.android.app.libx.presentation.viewmodel.AuthViewmodel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {

    val authViewModel: AuthViewmodel = hiltViewModel()
    val register by authViewModel.register.collectAsState()
    val verifyOtp by authViewModel.verifyOtp.collectAsState()
    var showSheet by remember {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()

    LaunchedEffect(verifyOtp) {
        if (verifyOtp is Response.Success && (verifyOtp as Response.Success).data.success) {
            if ((verifyOtp as Response.Success).data.user.role == "Admin"){
                authViewModel.setAdmin(true)
            }
            navController.navigate(Routes.Home.route)
        }
    }


    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
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
            .background(Color.Black)
            .padding(20.dp)
    ) {
        Image(
            modifier = Modifier
                .size(50.dp),
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo"
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Register to LibX",
            fontWeight = FontWeight.Medium,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(40.dp))

        AppTextField(
            text = name,
            placeholder = "Name"
        ) {
            name = it
        }
        Spacer(modifier = Modifier.height(10.dp))

        AppTextField(
            text = email,
            placeholder = "Email"
        ) {
            email = it
        }
        Spacer(modifier = Modifier.height(10.dp))

        PassTextField(
            password
        ) {
            password = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        AppButton(
            text = "Sign up"
        ) {
            authViewModel.register(
                RegisterRequest(name, email, password)
            )
            showSheet = true
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate("login")
                },
            text = "already have account?",
            color = BlackShaded
        )

        Spacer(modifier = Modifier.height(80.dp))

        if (showSheet) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    showSheet = false

                },

                ) {

                var showLoader by remember { mutableStateOf(false) }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {

                    when (register) {
                        is Response.Loading -> {
                            Loader()
                        }

                        is Response.Success -> {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,

                                ) {
                                Text(
                                    text = "ENTER OTP SEND TO YOUR MAIL",
                                    fontWeight = FontWeight.Medium,
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                VerifyOtpBox() { otp ->
                                    if (otp.length == 5) {
                                        authViewModel.verifyOtp(VerifyOtp(email, otp))
                                        showLoader = true
                                    }

                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                if(verifyOtp is Response.Error){
                                    showLoader = false
                                    Text(
                                        text = (verifyOtp as Response.Error).error.uppercase(),
                                        fontWeight = FontWeight.Bold
                                    )

                                }
                                if (showLoader) {
                                    Loader()
                                }
                            }
                        }

                        is Response.Error -> {
                            Text(
                                text = (register as Response.Error).error.uppercase(),
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }
                }
            }
        }
    }
}