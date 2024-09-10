package com.example.assignment2.data

import com.squareup.moshi.Json

data class authRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)
