package com.android.cryptocurrencyapp_compose.presentation.coin_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.cryptocurrencyapp_compose.data.remote.dto.TeamMember
import com.android.cryptocurrencyapp_compose.presentation.coin_details.component.CoinTag
import com.android.cryptocurrencyapp_compose.presentation.coin_details.component.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDeatilScreen(
    coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel()
) {

    val state = coinDetailsViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.coinDetail?.let { coin ->
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.bodyLarge,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            if (coin.isActive) "Active" else "Inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        coin.description,
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "tags",
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FlowRow(mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp, modifier = Modifier.fillMaxWidth()){
                        coin.tags.forEach {
                            CoinTag(it)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "Team member",
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                }
                items(coin.team){
                    item: TeamMember -> TeamListItem(teamMember = item, modifier = Modifier.fillMaxWidth().padding(10.dp ))
                    Divider()
                }

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

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}