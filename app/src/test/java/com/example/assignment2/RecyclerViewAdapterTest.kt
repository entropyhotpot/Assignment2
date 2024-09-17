package com.example.assignment2

import com.example.assignment2.data.ResponseItem
import com.example.assignment2.recyclerview.MyRecyclerViewAdapter
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class RecyclerViewAdapterTest {
    private lateinit var adapter: MyRecyclerViewAdapter
    private val mockNavigationFunction: (ResponseItem) -> Unit = {}
    private val exampleResponseItem = ResponseItem(
        country = "Australia",
        description = "Australia is a country and continent surrounded by the Indian and Pacific oceans.",
        bestSeason = "Summer",
        popularAttraction = "Sydney Opera House",
        destination = "Sydney"
    )

    @Before
    fun setUp() {
        adapter = spyk(MyRecyclerViewAdapter(navigationFunction = mockNavigationFunction))
        every { adapter.notifyDataSetChanged() } returns Unit
    }

    @Test
    fun `getItemCount should return the number of items in the list`() {
        // Given
        val listOfItems = mutableListOf(
            exampleResponseItem,
            exampleResponseItem.copy(country = "USA"),
            exampleResponseItem.copy(country = "Canada"))

        adapter.setData(listOfItems)

        // When
        val itemCount = adapter.getItemCount()

        // Then
        assertEquals(3, itemCount)
    }

    @Test
    fun `setData should update the list of items and calls notifyDataSetChanged`() {
        // Given
        val listOfItems = mutableListOf(
            exampleResponseItem,
            exampleResponseItem.copy(country = "USA"),
            exampleResponseItem.copy(country = "Canada"))

        // When
        adapter.setData(listOfItems)

        // Then
        assertEquals(3, adapter.getItemCount())
        verify { adapter.notifyDataSetChanged() }
    }
}