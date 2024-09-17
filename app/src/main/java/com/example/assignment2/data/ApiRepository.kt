package com.example.assignment2.data

import com.example.assignment2.Network.ApiClient
import com.example.assignment2.Network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun authAPI(item: authRequest) = apiService.authAPI(data = item)

    suspend fun getAllItems(topic: String) = apiService.getAllItems(topic)
}