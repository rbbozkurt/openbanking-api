package com.rbbozkurt.openbankingapi.service.plaid.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

/**
 * Exception thrown by PlaidService when operations fail.
 */
class PlaidServiceException(
    message: String,
    val statusCode: HttpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR,
    val details: Any = "Unknown Error",
    cause: Throwable? = null,
) : RuntimeException(message, cause)
