package com.android.app.libx.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.register.VerifyOtp
import com.android.app.libx.data.models.user.User
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewmodel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val register : MutableStateFlow<Response<RegisterResponse>> = MutableStateFlow(Response.Success(RegisterResponse(false,"")))
    val login : MutableStateFlow<Response<RegisterResponse>> = MutableStateFlow(Response.Success(RegisterResponse(false,"")))
    val verifyOtp : MutableStateFlow<Response<LoginResponse>> = MutableStateFlow(Response.Success(LoginResponse(false,"", "", User("","","","", "", false, emptyList(),"", "", -1))))

    fun register(request: RegisterRequest) = viewModelScope.launch(Dispatchers.IO) {
            repository.register(request).collect{
                register.value = it
        }
    }

    fun login(request: LoginRequest) = viewModelScope.launch(Dispatchers.IO) {
        repository.login(request)
    }

    fun verifyOtp(request: VerifyOtp) = viewModelScope.launch(Dispatchers.IO) {
        repository.verifyOtp(request).collect{
            verifyOtp.value = it
        }
    }

    fun logout() = viewModelScope.launch(Dispatchers.IO) {
        repository.logout()
    }
}