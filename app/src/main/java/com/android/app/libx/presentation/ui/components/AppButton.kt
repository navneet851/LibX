package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.app.libx.ui.theme.BlackShaded

@Preview
@Composable
fun AppButton(
    modifier : Modifier = Modifier,
    text : String,
    textColor : Color = Color.Black,
    buttonColor : Color = Color.White,
    onClick : () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
        ,
        onClick = onClick,
//        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor
        ),
    ) {
        Text(text = text)
    }
}