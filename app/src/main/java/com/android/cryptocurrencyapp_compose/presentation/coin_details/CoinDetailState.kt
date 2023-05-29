package com.android.cryptocurrencyapp_compose.presentation.coin_details

import com.android.cryptocurrencyapp_compose.domain.model.Coin
import com.android.cryptocurrencyapp_compose.domain.model.CoinDetail

data class CoinDetailState(
    val  isLoading:Boolean =false,
    val coinDetail: CoinDetail?=null,
    val error:String=""
)