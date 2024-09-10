package com.example.assignment2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.Network.ApiClient
import com.example.assignment2.data.ResponseItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel: ViewModel() {

    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    val apiService = ApiClient().apiService

    init {

        viewModelScope.launch {
            val result = apiService.getAllItems("travel")
            apiResponseObjects.value = result
        }
    }
}