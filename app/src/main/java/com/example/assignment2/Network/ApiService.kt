package com.example.assignment2.Network

import com.example.assignment2.data.ApiResponse
import com.example.assignment2.data.ResponseItem
import com.example.assignment2.data.authRequest
import com.example.assignment2.data.authResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.POST

interface ApiService {

    // Request to login to API
    @POST("footscray/auth")
    suspend fun authAPI(@Body data: authRequest): authResponse

    // Request to grab all items
    @GET("dashboard/{topic}")
    suspend fun getAllItems(@Path("topic") topic: String): ApiResponse

}