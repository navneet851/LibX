package com.android.app.libx.data.models.book

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("_id") val id: String,
    val title: String,
    val author: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val availability: Boolean,
    val createdAt: String,
    val updatedAt: String,
    @SerializedName("__v") val version: Int
)