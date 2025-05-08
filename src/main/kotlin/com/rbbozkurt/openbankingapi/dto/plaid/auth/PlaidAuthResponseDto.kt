package com.rbbozkurt.openbankingapi.dto.plaid.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaidAuthResponse(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("item_id")
    val itemId: String,
    @JsonProperty("request_id")
    val requestId: String,
)
