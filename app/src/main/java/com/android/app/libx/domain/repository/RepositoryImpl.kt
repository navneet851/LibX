package com.android.app.libx.domain.repository

import android.util.Log
import com.android.app.libx.data.api.ApiService
import com.android.app.libx.data.models.book.BooksResponse
import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.register.VerifyOtp
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UserResponse
import com.android.app.libx.data.models.user.UsersResponse
import com.android.app.libx.domain.entities.Response
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    private fun getErrorMessage(errorBody: String?): String {
        return if (errorBody != null) {
            try {
                JSONObject(errorBody).getString("message")
            } catch (e: Exception) {
                "try again"
            }
        } else {
            "try again"
        }
    }


    override suspend fun getUser(): Flow<Response<UserResponse>> {
        val response = apiService.getUser()
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                val errorBody = response.errorBody()?.string()
                emit(Response.Error(getErrorMessage(errorBody)))
            }
        }
    }

    override suspend fun login(request: LoginRequest): Flow<Response<LoginResponse>> {
        val response = apiService.login(request)
        return flow {
            emit(Response.Loading())
            delay(500)
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                val errorBody = response.errorBody()?.string()
                emit(Response.Error(getErrorMessage(errorBody)))
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
                val errorBody = response.errorBody()?.string()
                emit(Response.Error(getErrorMessage(errorBody)))
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
                val errorBody = response.errorBody()?.string()
                emit(Response.Error(getErrorMessage(errorBody)))
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


    // book

    override suspend fun getAllBooks(): Flow<Response<BooksResponse>> {
        val response = apiService.getAllBooks()
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                val errorBody = response.errorBody()?.string()
                emit(Response.Error(getErrorMessage(errorBody)))
            }
        }
    }

    //Admin

    override suspend fun getAllUsers(): Flow<Response<UsersResponse>> {
        val response = apiService.getAllUsers()
        return flow {
            emit(Response.Loading())
            if (response.isSuccessful && response.body()!!.success) {
                emit(Response.Success(response.body()!!))
            } else {
                val errorBody = response.errorBody()?.string()
                emit(Response.Error(getErrorMessage(errorBody)))
            }
        }
    }
}