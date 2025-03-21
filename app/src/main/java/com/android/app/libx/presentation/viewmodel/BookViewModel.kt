package com.android.app.libx.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.libx.data.models.book.BooksResponse
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val books : MutableStateFlow<Response<BooksResponse>> = MutableStateFlow(Response.Loading())

    init {
        getAllBooks()
    }
    private fun getAllBooks() = viewModelScope.launch(Dispatchers.IO){
        repository.getAllBooks().collect{
            books.value = it as Response<BooksResponse>
        }
    }
}