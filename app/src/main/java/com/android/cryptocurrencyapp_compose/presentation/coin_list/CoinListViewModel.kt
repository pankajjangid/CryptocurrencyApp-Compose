package com.android.cryptocurrencyapp_compose.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.cryptocurrencyapp_compose.common.Resource
import com.android.cryptocurrencyapp_compose.domain.model.Coin
import com.android.cryptocurrencyapp_compose.domain.use_case.get_coin.GetCoinUseCase
import com.android.cryptocurrencyapp_compose.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val coinUseCase: GetCoinsUseCase):ViewModel() {

    private val _state = mutableStateOf(CoinListState())
        val state:State<CoinListState> = _state

    init {
        getCoins()
    }
    private  fun getCoins(){
        coinUseCase().onEach {
            when(it){
                is Resource.Success->{
                    _state.value = CoinListState(coinList = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = it.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}