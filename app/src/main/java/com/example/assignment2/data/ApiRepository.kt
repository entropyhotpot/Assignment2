package com.example.assignment2.data

import com.example.assignment2.Network.ApiClient

class ApiRepository {

    val apiService = ApiClient().apiService

    suspend fun authAPI(item: authRequest) = apiService.authAPI(data = item)

    suspend fun getAllItems(topic: String) = apiService.getAllItems(topic)
}