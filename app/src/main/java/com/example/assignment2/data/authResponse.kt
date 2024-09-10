package com.example.assignment2.data

import com.squareup.moshi.Json

data class authResponse(
    @Json(name = "keypass") val topic: String
)
