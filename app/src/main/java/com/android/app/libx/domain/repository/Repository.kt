package com.android.app.libx.domain.repository

import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UserResponse
import retrofit2.Response

interface Repository {
    suspend fun login(request: LoginRequest): Response<LoginResponse>
    suspend fun register(request: RegisterRequest): Response<RegisterResponse>
    suspend fun getUser(): Response<UserResponse>

}