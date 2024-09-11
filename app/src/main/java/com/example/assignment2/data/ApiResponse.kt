package com.example.assignment2.data

import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "entities") val entities: List<ResponseItem>,
    @Json(name = "entityTotal") val entityTotal: Int
)