package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun VerifyOtpBox(onOtpEntered: (String) -> Unit = {}) {
    val otp1 = remember { mutableStateOf("") }
    val otp2 = remember { mutableStateOf("") }
    val otp3 = remember { mutableStateOf("") }
    val otp4 = remember { mutableStateOf("") }
    val otp5 = remember { mutableStateOf("") }

    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }
    val focusRequester5 = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Row {
        OutlinedTextField(
            value = otp1.value,
            onValueChange = {
                if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                    otp1.value = it
                    if (it.isNotEmpty()) focusRequester2.requestFocus()
                    onOtpEntered(otp1.value + otp2.value + otp3.value + otp4.value + otp5.value)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(50.dp)
                .focusRequester(focusRequester1)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = otp2.value,
            onValueChange = {
                if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                    otp2.value = it
                    if (it.isNotEmpty()) focusRequester3.requestFocus()
                    onOtpEntered(otp1.value + otp2.value + otp3.value + otp4.value + otp5.value)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(50.dp)
                .focusRequester(focusRequester2)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = otp3.value,
            onValueChange = {
                if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                    otp3.value = it
                    if (it.isNotEmpty()) focusRequester4.requestFocus()
                    onOtpEntered(otp1.value + otp2.value + otp3.value + otp4.value + otp5.value)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(50.dp)
                .focusRequester(focusRequester3)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = otp4.value,
            onValueChange = {
                if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                    otp4.value = it
                    if (it.isNotEmpty()) focusRequester5.requestFocus()
                    onOtpEntered(otp1.value + otp2.value + otp3.value + otp4.value + otp5.value)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(50.dp)
                .focusRequester(focusRequester4)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = otp5.value,
            onValueChange = {
                if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                    otp5.value = it
                    if (it.isNotEmpty()) focusManager.clearFocus()
                    onOtpEntered(otp1.value + otp2.value + otp3.value + otp4.value + otp5.value)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(50.dp)
                .focusRequester(focusRequester5)
        )
    }
}