package com.rbbozkurt.openbankingapi.dto.plaid.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaidAuthRequestDto(
    @JsonProperty("client_id")
    val clientId: String,
    @JsonProperty("secret")
    val secret: String,
    @JsonProperty("institution_id")
    val institutionId: String,
    @JsonProperty("initial_products")
    val initialProducts: List<String>,
)
