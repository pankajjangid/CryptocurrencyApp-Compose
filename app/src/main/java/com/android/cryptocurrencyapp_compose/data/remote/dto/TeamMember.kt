package com.android.cryptocurrencyapp_compose.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)