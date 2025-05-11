package com.rbbozkurt.openbankingapi.client.plaid.transactions.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionsSyncRequest(
    @JsonProperty("client_id")
    val clientId: String,
    @JsonProperty("secret")
    val secret: String,
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("cursor")
    val cursor: String? = null,
    @JsonProperty("count")
    val count: Int? = null,
    @JsonProperty("options")
    val options: TransactionsSyncOptions? = null,
)

data class TransactionsSyncOptions(
    @JsonProperty("include_original_description")
    val includeOriginalDescription: Boolean? = null,
)
