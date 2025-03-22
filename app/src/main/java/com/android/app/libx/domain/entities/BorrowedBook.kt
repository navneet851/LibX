package com.android.app.libx.domain.entities

data class BorrowedBook(
    val bookId: String,
    val returned: Boolean,
    val bookTitle: String,
    val borrowedDate: String,
    val dueDate: String,
    val _id: String
)