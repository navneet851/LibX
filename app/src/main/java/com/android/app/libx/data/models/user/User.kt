package com.android.app.libx.data.models.user

import com.android.app.libx.domain.entities.BorrowedBook
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id") val id: String,
    val name: String,
    val email: String,
    val password: String,
    val role: String,
    val accountVerified: Boolean,
    val borrowedBooks: List<BorrowedBook>,
    val createdAt: String,
    val updatedAt: String,
    @SerializedName("__v") val version: Int
)