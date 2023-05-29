package com.android.cryptocurrencyapp_compose.domain.repository

import com.android.cryptocurrencyapp_compose.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String) : CoinDetailDto
}