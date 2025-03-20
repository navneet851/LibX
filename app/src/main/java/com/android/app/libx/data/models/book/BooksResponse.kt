package com.android.app.libx.data.models.book

data class BooksResponse(
    val success : Boolean,
    val message : String = "",
    val books: List<Book>
)