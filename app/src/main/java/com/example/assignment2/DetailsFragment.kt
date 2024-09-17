package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.assignment2.ui.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val detailsViewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val responseItem = args.detail
        detailsViewModel.bind(responseItem)

        view.findViewById<TextView>(R.id.detailsDestination).text = detailsViewModel.destinationText.value
        view.findViewById<TextView>(R.id.detailsCountry).text = detailsViewModel.countryText.value
        view.findViewById<TextView>(R.id.detailsBestSeason).text = detailsViewModel.bestSeasonText.value
        view.findViewById<TextView>(R.id.detailsPopularAttraction).text = detailsViewModel.popularAttractionText.value
        view.findViewById<TextView>(R.id.detailsDescription).text = detailsViewModel.descriptionText.value

    }
}