package com.android.app.libx.domain.repository

import com.android.app.libx.data.api.ApiService
import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UserResponse
import com.android.app.libx.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return apiService.login(request)
    }

    override suspend fun register(request: RegisterRequest): Response<RegisterResponse> {
        return apiService.register(request)
    }

    override suspend fun getUser(): Response<UserResponse> {
        return apiService.getUser()
    }
}