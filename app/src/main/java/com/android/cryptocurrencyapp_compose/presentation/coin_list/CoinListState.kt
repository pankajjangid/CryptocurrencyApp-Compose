package com.android.cryptocurrencyapp_compose.presentation.coin_list

import com.android.cryptocurrencyapp_compose.domain.model.Coin

data class CoinListState(
    val  isLoading:Boolean =false,
    val coinList:List<Coin> = emptyList(),
    val error:String=""
)