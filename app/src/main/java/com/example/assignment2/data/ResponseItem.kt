package com.example.assignment2.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseItem(
    @Json(name = "destination") val destination: String,
    @Json(name = "country") val country: String,
    @Json(name = "bestSeason") val bestSeason: String,
    @Json(name = "popularAttraction") val popularAttraction: String,
    @Json(name = "description") val description: String
): Parcelable
