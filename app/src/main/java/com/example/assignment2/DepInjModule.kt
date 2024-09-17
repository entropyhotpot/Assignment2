package com.example.assignment2

import com.example.assignment2.Network.ApiClient
import com.example.assignment2.Network.ApiService
import com.example.assignment2.data.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DepInjModule {

    @Provides
    fun provideApiService(): ApiService {
        return ApiClient().apiService
    }

}