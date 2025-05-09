package com.rbbozkurt.openbankingapi.client.plaid.auth.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePublicTokenResponse(
    @JsonProperty("public_token")
    val publicToken: String,
    @JsonProperty("request_id")
    val requestId: String,
)
