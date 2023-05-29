package com.android.cryptocurrencyapp_compose.data.di

import com.android.cryptocurrencyapp_compose.common.Constant
import com.android.cryptocurrencyapp_compose.data.remote.ApiService
import com.android.cryptocurrencyapp_compose.data.repository.CoinRepositoryImpl
import com.android.cryptocurrencyapp_compose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetCoinRepository(api: ApiService): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}