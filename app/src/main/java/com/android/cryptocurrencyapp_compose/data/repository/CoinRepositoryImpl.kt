package com.android.cryptocurrencyapp_compose.data.repository

import com.android.cryptocurrencyapp_compose.data.remote.ApiService
import com.android.cryptocurrencyapp_compose.data.remote.dto.CoinDto
import com.android.cryptocurrencyapp_compose.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: ApiService) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return  api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}