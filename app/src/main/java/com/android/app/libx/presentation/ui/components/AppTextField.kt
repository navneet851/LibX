package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.app.libx.ui.theme.BlackShaded


@Composable
fun AppTextField(
    text : String,
    placeholder : String,
    onValueChange : (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .border(Dp.Hairline, Color.White, RoundedCornerShape(10.dp))
        ,
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = BlackShaded
            )
        },
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
        )
    )
}