package com.android.app.libx.domain.repository

import com.android.app.libx.data.models.book.BooksResponse
import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.register.VerifyOtp
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UserResponse
import com.android.app.libx.domain.entities.Response
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getUser(): Flow<Response<UserResponse>>
    //Auth
    suspend fun login(request: LoginRequest): Flow<Response<LoginResponse>>
    suspend fun verifyOtp(request: VerifyOtp): Flow<Response<LoginResponse>>
    suspend fun register(request: RegisterRequest): Flow<Response<RegisterResponse>>
    suspend fun logout(): Flow<Response<RegisterResponse>>

    //book

    suspend fun  getAllBooks(): Flow<Response<BooksResponse>>

}