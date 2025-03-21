package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.app.libx.data.models.book.Book


@Composable
fun BookTemplate(book : Book) {
    Column(
        modifier = Modifier
            .padding(0.dp, 6.dp)
            .fillMaxWidth()
            .border(Dp.Hairline, Color.Gray, RoundedCornerShape(10.dp))
            .padding(12.dp)
    ) {
        Text(
            text = book.title,
            fontSize = 23.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Author: ${book.author}",
                color = Color.Gray,
                fontSize = 13.sp,
                letterSpacing = 0.sp,
            )
            Text(
                text = "₹${book.price}",
                fontSize = 16.sp,
                color = Color.LightGray
            )

        }
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = "Description",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray
        )
        Text(
            text = book.description,
            color = Color.Gray,
            fontSize = 14.sp,
            lineHeight = 18.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))

        AppButton(
            modifier = Modifier
                .height(38.dp)
                .border(Dp.Hairline, Color.LightGray, RoundedCornerShape(19.dp))
            ,
            text = if(book.availability) "Borrow" else "Not Available",
            buttonColor = if(book.availability) Color.White else Color.Transparent,
            textColor = if(book.availability) Color.Black else Color.LightGray
        ) {

        }
    }
}

@Preview
@Composable
private fun BookTemplatePreview() {
    val book = Book(
        id = "1",
        title = "Harry Potter",
        author = "Mark Henry",
        description = "A novel about the American dream and the excess of the Jazz Age",
        price = 16.99,
        quantity = 5,
        availability = false,
        createdAt = "fdfgdf",
        updatedAt = "fsdfgd",
        version = 1,
    )
    BookTemplate(book)
}