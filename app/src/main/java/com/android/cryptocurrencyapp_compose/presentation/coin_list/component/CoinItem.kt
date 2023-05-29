package com.android.cryptocurrencyapp_compose.presentation.coin_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.cryptocurrencyapp_compose.domain.model.Coin


@Composable
fun CoinItem(coin: Coin, onItemClick: (Coin) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable {onItemClick(coin) }.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            if (coin.isActive) "Active" else "Inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}