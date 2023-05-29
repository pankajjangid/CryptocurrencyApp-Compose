package com.android.cryptocurrencyapp_compose.data.remote

import com.android.cryptocurrencyapp_compose.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId:String) : CoinDetailDto
}