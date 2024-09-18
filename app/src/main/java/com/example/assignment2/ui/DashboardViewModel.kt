package com.example.assignment2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.Network.ApiClient
import com.example.assignment2.data.ApiRepository
import com.example.assignment2.data.ResponseItem
import com.example.assignment2.data.authResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {

    // Initialize MutableStateFlow for each field in the DashboardFragment
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    private lateinit var authResponse: authResponse

    // Grab the topic from the API
    fun setAuthResponse(response: authResponse) {
        authResponse = response
        fetchApiResponseObjects()
    }

    // Fetch the corresponding API response objects
    private fun fetchApiResponseObjects() {
        viewModelScope.launch {
            val result = repository.getAllItems(authResponse.topic)
            apiResponseObjects.value = result.entities
        }
    }
}