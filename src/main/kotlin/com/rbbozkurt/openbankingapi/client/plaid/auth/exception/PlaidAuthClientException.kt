package com.rbbozkurt.openbankingapi.client.plaid.auth.exception

import org.springframework.http.HttpStatusCode

class PlaidAuthClientException(
    message: String,
    val statusCode: HttpStatusCode,
    val details: Any? = "Unknown Error",
    cause: Throwable? = null,
) : RuntimeException(message, cause)
