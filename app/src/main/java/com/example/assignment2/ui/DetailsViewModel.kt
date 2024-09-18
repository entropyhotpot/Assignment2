package com.example.assignment2.ui

import androidx.lifecycle.ViewModel
import com.example.assignment2.data.ResponseItem
import kotlinx.coroutines.flow.MutableStateFlow

class DetailsViewModel: ViewModel() {

    val destinationText = MutableStateFlow("")
    val countryText = MutableStateFlow("")
    val bestSeasonText = MutableStateFlow("")
    val popularAttractionText = MutableStateFlow("")
    val descriptionText = MutableStateFlow("")

    fun bind(item: ResponseItem) {
        destinationText.value = "Destination: ${item.destination}"
        countryText.value = "Country: ${item.country}"
        bestSeasonText.value = "Best Season: ${item.bestSeason}"
        popularAttractionText.value = "Popular Attraction: ${item.popularAttraction}"
        descriptionText.value = "Description: ${item.description}"
    }

}