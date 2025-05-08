package com.rbbozkurt.openbankingapi.dto.plaid.auth

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpStatusCode

data class PlaidAuthErrorResponse(
    @JsonProperty("error")
    val error: String,
    @JsonProperty("status_code")
    val statusCode: HttpStatusCode,
    @JsonProperty("details")
    val details: Any? = "Unknown Error",
)
