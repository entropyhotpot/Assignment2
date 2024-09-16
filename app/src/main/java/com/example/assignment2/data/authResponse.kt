package com.example.assignment2.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class authResponse(
    @Json(name = "keypass") val topic: String
): Parcelable
