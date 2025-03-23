package com.android.app.libx.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UsersResponse
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val users: MutableStateFlow<Response<UsersResponse>> = MutableStateFlow(Response.Loading())

    init {
        getAllUsers()
    }

    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllUsers().collect {
            users.value = it
        }
    }
}
