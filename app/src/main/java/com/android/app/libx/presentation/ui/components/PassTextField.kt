package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.app.libx.R
import com.android.app.libx.ui.theme.BlackShaded

@Preview
@Composable
fun PassTextField(

) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        modifier = Modifier
            .border(Dp.Hairline, Color.White, RoundedCornerShape(10.dp))
        ,
        value = "Email",
        onValueChange = {},
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Black,
            unfocusedContainerColor = Color.Black,
            disabledContainerColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White,
            disabledTextColor = Color.White,
            unfocusedPlaceholderColor = BlackShaded,
            focusedPlaceholderColor = BlackShaded,
            disabledPlaceholderColor = BlackShaded,
            cursorColor = Color.White,
            selectionColors = TextSelectionColors(
                handleColor = Color.White,
                backgroundColor = BlackShaded
            )
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = if (passwordVisible) {
                        painterResource(id = R.drawable.baseline_visibility_24)
                    }
                    else{
                        painterResource(id = R.drawable.baseline_visibility_off_24)
                    }, contentDescription = "password"
                )
            }
        }
    )
}