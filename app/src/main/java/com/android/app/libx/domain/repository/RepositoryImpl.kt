package com.android.app.libx.domain.repository

import com.android.app.libx.data.api.ApiService
import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.register.VerifyOtp
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UserResponse
import com.android.app.libx.domain.entities.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {


    override suspend fun getUser(): Flow<Response<UserResponse>> {
        val response = apiService.getUser()
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                emit(Response.Error(response.message()))
            }
        }
    }

    override suspend fun login(request: LoginRequest): Flow<Response<LoginResponse>> {
        val response = apiService.login(request)
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                emit(Response.Error(response.message()))
            }
        }

    }

    override suspend fun verifyOtp(request: VerifyOtp): Flow<Response<LoginResponse>> {
        val response = apiService.verifyOtp(request)
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                emit(Response.Error(response.message()))
            }
        }
    }

    override suspend fun register(request: RegisterRequest): Flow<Response<RegisterResponse>> {
        val response = apiService.register(request)
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                emit(Response.Error(response.message()))
            }
        }
    }

    override suspend fun logout(): Flow<Response<RegisterResponse>> {
        val response = apiService.logout()
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                emit(Response.Error(response.message()))
            }
        }
    }
}