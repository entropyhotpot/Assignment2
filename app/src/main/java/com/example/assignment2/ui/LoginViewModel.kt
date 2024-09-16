package com.example.assignment2.ui


import com.example.assignment2.Network.ApiClient
import com.example.assignment2.data.authRequest
import com.example.assignment2.data.authResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {

    private val _loginResponse = MutableStateFlow<authResponse?>(null)
    val loginResponse: StateFlow<authResponse?> = _loginResponse

    fun login(username: String, password: String) {
        val authRequest = authRequest(username, password)
        viewModelScope.launch {
           val apiService = ApiClient().apiService
           val response = apiService.authAPI(authRequest)
           _loginResponse.value = response
        }

    }

}