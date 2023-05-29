package com.android.cryptocurrencyapp_compose.presentation.coin_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.cryptocurrencyapp_compose.domain.model.Coin
import com.android.cryptocurrencyapp_compose.presentation.Screen
import com.android.cryptocurrencyapp_compose.presentation.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    coinListViewModel: CoinListViewModel = hiltViewModel()
) {

    val state = coinListViewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coinList) { coin: Coin ->
                CoinItem(coin = coin, onItemClick = {
                    navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                state.error,
                modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.Center),
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }

        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}