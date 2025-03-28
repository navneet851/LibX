package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.app.libx.domain.entities.BorrowedBook


@Composable
fun BorrowedBookTemplate(borrowedBook: BorrowedBook, onClick : () -> Unit) {
    Column(
        modifier = Modifier
            .padding(0.dp, 6.dp)
            .fillMaxWidth()
            .border(Dp.Hairline, Color.Gray, RoundedCornerShape(10.dp))
            .padding(12.dp)
    ) {
        Text(
            text = borrowedBook.bookTitle,
            fontSize = 23.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Text(
            text = "borrowed on : ${borrowedBook.borrowedDate}",
            color = Color.Gray,
            fontSize = 13.sp,
            letterSpacing = 0.sp,
        )
        Text(
            text = "due on : ${borrowedBook.dueDate}",
            color = Color.Gray,
            fontSize = 13.sp,
            letterSpacing = 0.sp,
        )

        Spacer(modifier = Modifier.padding(5.dp))

        AppButton(
            modifier = Modifier
                .height(38.dp)
                .border(Dp.Hairline, Color.LightGray, RoundedCornerShape(19.dp))
            ,
            text = if(borrowedBook.returned) "Returned" else "Not Available",
            buttonColor = if(borrowedBook.returned) Color.Transparent else Color.White,
            textColor = if(borrowedBook.returned) Color.LightGray else Color.Black
        ) {
            if (!borrowedBook.returned){
                onClick()
            }
        }
    }
}