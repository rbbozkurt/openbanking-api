package com.rbbozkurt.openbankingapi.dto.plaid.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaidAuthResponseDto(
    @JsonProperty("public_token")
    val publicToken: String,
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("item_id")
    val itemId: String,
    @JsonProperty("request_id")
    val requestId: String,
)
