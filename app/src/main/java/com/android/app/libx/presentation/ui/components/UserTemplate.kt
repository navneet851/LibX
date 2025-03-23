package com.android.app.libx.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.app.libx.data.models.user.User


@Composable
fun UserTemplate(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(0.dp, 3.dp)
            .border(Dp.Hairline, Color.Gray, RoundedCornerShape(10))
            .padding(10.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = user.name,
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(4.dp))
            if (user.role == "Admin") {
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
                text = user.email,
                color = Color.Gray,
                fontSize = 15.sp,
                letterSpacing = 0.sp,
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            modifier = Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(30))
                .padding(5.dp)
                .align(Alignment.CenterHorizontally),
            text = "Borrowed Books",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray
        )

        HorizontalDivider()
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                if (user.borrowedBooks.isEmpty()){
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "No Book Found",
                        color = Color.Gray
                    )
                }
            }
            items(user.borrowedBooks.size){
                BorrowedBookTemplate(user.borrowedBooks[it]){

                }
            }
        }
    }
}