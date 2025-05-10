package com.rbbozkurt.openbankingapi.dto.plaid.error

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpStatusCode

data class PlaidErrorResponseDto(
    @JsonProperty("error")
    val error: String,
    @JsonProperty("status_code")
    val statusCode: HttpStatusCode,
    @JsonProperty("details")
    val details: Any? = "Unknown Error",
)
