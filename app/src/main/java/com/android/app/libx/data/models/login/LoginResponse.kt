package com.android.app.libx.data.models.login

import com.android.app.libx.data.models.user.User

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String,
    val user: User
)