package com.example.assignment2.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.data.ResponseItem

class ResponseItemViewHolder(view: View, private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val destination: TextView = view.findViewById(R.id.itemDestinationText)
    private val country: TextView = view.findViewById(R.id.itemCountryText)
    private val bestSeason: TextView = view.findViewById(R.id.itemBestSeasonText)
    private val popularAttraction: TextView = view.findViewById(R.id.itemPopularAttractionText)
    private val button: Button = view.findViewById(R.id.navigationButton)

    fun bind(item: ResponseItem) {
        destination.text = item.destination
        country.text = item.country
        bestSeason.text = item.bestSeason
        popularAttraction.text = item.popularAttraction

        button.setOnClickListener {
            navigationFunction(item)
        }
    }
}
