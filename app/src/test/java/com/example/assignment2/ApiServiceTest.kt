package com.example.assignment2.Network

import com.example.assignment2.data.authRequest
import com.example.assignment2.data.authResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@OptIn(ExperimentalCoroutinesApi::class)
class ApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test authAPI returns authResponse`() = runTest {
        val mockResponse = MockResponse()
            .setBody("""{"keypass": "test_token"}""")
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val request = authRequest("username", "password")
        val response = apiService.authAPI(request)


        advanceUntilIdle()
        assertEquals("test_token", response.topic)
    }
}