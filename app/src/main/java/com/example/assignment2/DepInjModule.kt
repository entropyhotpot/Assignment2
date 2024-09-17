package com.example.assignment2

import com.example.assignment2.Network.ApiClient
import com.example.assignment2.Network.ApiService
import com.example.assignment2.data.ResponseItem
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

    @Provides
    fun provideDataList(): MutableList<ResponseItem> {
        return mutableListOf()
    }

    @Provides
    fun provideNavigationFunction(): (ResponseItem) -> Unit {
        return {}
    }

}