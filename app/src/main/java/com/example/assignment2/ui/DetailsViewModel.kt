package com.example.assignment2.ui

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.assignment2.R
import com.example.assignment2.data.ResponseItem
import kotlinx.coroutines.flow.MutableStateFlow

class DetailsViewModel: ViewModel() {

    val destinationText = MutableStateFlow("")
    val countryText = MutableStateFlow("")
    val bestSeasonText = MutableStateFlow("")
    val popularAttractionText = MutableStateFlow("")
    val descriptionText = MutableStateFlow("")

    fun bind(item: ResponseItem) {
        destinationText.value = item.destination
        countryText.value = item.country
        bestSeasonText.value = item.bestSeason
        popularAttractionText.value = item.popularAttraction
        descriptionText.value = item.description
    }

}