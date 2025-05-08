package com.rbbozkurt.openbankingapi.client.plaid.auth.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePublicTokenRequest(
    @JsonProperty("client_id")
    val clientId: String,
    @JsonProperty("secret")
    val secret: String,
    @JsonProperty("institution_id")
    val institutionId: String,
    @JsonProperty("initial_products")
    val initialProducts: List<String>,
)
