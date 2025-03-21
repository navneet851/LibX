package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.ui.components.AppButton
import com.android.app.libx.presentation.ui.components.AppTextField
import com.android.app.libx.presentation.ui.components.BookTemplate
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.viewmodel.BookViewModel

@Preview
@Composable
fun LibraryScreen() {
    val booksViewModel : BookViewModel = hiltViewModel()
    val books by booksViewModel.books.collectAsState()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        when(books){
            is Response.Loading -> {
                Loader()
            }
            is Response.Success -> {
                val booksList = (books as Response.Success).data.books

                AppButton(
                    modifier = Modifier
                        .height(40.dp)
                        .border(Dp.Hairline, Color.LightGray, RoundedCornerShape(30.dp))
                    ,
                    text = "Add Book",
                    textColor = Color.LightGray,
                    buttonColor = Color.Transparent
                ) {

                }

                LazyColumn(
                    modifier = Modifier.padding(0.dp, 10.dp)
                ) {
                    items(booksList.size){
                        BookTemplate(booksList[it])
                    }
                }
            }
            is Response.Error -> {
                Text((books as Response.Error).error.uppercase())
            }
        }
    }
}