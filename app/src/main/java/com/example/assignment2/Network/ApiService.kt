package com.example.assignment2.Network

import com.example.assignment2.data.ResponseItem
import com.example.assignment2.data.authRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.POST

interface ApiService {

    // Request to login to API
    @POST("footscray/auth")
    suspend fun authAPI(@Body data: authRequest): authRequest

    // Request to grab all items
    @GET("dashboard/{topic}")
    suspend fun getAllItems(@Path("topic") topic: String): List<ResponseItem>

}