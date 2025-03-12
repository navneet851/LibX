package com.android.app.libx.data.api

import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.user.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest) : Response<LoginResponse>

    @POST("api/v1/auth/register")
    suspend fun register(@Body request: RegisterRequest) : Response<RegisterResponse>

}