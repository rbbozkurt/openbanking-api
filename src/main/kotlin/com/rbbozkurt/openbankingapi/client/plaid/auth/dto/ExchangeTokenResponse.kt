package com.rbbozkurt.openbankingapi.client.plaid.auth.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExchangeTokenResponse(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("item_id")
    val itemId: String,
    @JsonProperty("request_id")
    val requestId: String,
)
