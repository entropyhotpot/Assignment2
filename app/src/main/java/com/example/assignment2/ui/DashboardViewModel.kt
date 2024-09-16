package com.example.assignment2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.Network.ApiClient
import com.example.assignment2.data.ResponseItem
import com.example.assignment2.data.authResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel: ViewModel() {

    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    val apiService = ApiClient().apiService
    private lateinit var authResponse: authResponse

    fun setAuthResponse(response: authResponse) {
        authResponse = response
        fetchApiResponseObjects()
    }

    private fun fetchApiResponseObjects() {
        viewModelScope.launch {
            val result = apiService.getAllItems(authResponse.topic)
            apiResponseObjects.value = result.entities
        }
    }
}