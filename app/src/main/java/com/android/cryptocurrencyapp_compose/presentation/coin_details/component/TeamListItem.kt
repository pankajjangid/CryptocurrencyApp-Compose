package com.android.cryptocurrencyapp_compose.presentation.coin_details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.android.cryptocurrencyapp_compose.data.remote.dto.TeamMember

@Composable
fun TeamListItem(teamMember: TeamMember,modifier: Modifier = Modifier){
    Column(modifier=modifier, verticalArrangement = Arrangement.Center) {
        Text(teamMember.name, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(teamMember.position, style = MaterialTheme.typography.bodySmall, fontStyle = FontStyle.Italic)


    }
}