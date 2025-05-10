package com.rbbozkurt.openbankingapi.client.plaid.exception

import org.springframework.http.HttpStatusCode

class PlaidClientException(
    message: String,
    val statusCode: HttpStatusCode,
    val details: Any = "Unknown Error",
    cause: Throwable? = null,
) : RuntimeException(message, cause)
