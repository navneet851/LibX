package com.android.app.libx.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.ui.components.AppTextField
import com.android.app.libx.presentation.ui.components.BookTemplate
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.viewmodel.BookViewModel

@Preview
@Composable
fun SearchScreen() {
    val booksViewModel : BookViewModel = hiltViewModel()
    val books by booksViewModel.books.collectAsState()

    var text by remember{
        mutableStateOf("")
    }


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
                val booksList = if (text.isNotEmpty()){
                    (books as Response.Success).data.books.filter { book ->
                        book.title.contains(text, ignoreCase = true) || book.author.contains(text, ignoreCase = true)
                    }
                }
                else {
                    emptyList()
                }
                AppTextField(
                    text = text,
                    placeholder = "Search Book"
                ) {
                    text = it
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