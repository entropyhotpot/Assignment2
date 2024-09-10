package com.example.assignment2.data

import com.squareup.moshi.Json

data class ResponseItem(
    @Json(name = "destination") val destination: String,
    @Json(name = "country") val country: String,
    @Json(name = "bestSeason") val bestSeason: String,
    @Json(name = "popularAttraction") val popularAttraction: String,
    @Json(name = "description") val description: String
)
