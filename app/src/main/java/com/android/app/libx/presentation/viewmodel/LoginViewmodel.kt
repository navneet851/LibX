package com.android.app.libx.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
//            val response1 = repository.login(LoginRequest("nav700neet@gmail.com", "navbarneet"))
//            Log.d("LoginViewmodel", "login: ${response1.body()}")
//
//            delay(3000)
            val response = repository.getUser()
            Log.d("LoginViewmodel", "getUser: ${response.body()!!.user}")
        }

    }
}