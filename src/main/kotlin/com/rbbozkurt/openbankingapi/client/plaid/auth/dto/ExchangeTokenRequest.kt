package com.rbbozkurt.openbankingapi.client.plaid.auth.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExchangeTokenRequest(
    @JsonProperty("client_id")
    val clientId: String,
    @JsonProperty("secret")
    val secret: String,
    @JsonProperty("public_token")
    val publicToken: String,
)
