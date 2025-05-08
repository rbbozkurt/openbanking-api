package com.rbbozkurt.openbankingapi.service.plaid.auth.exception

/**
 * Exception thrown by PlaidAuthService when authentication-related operations fail.
 */
class PlaidAuthServiceException(
    message: String,
    val details: Any? = "Unknown Error",
    cause: Throwable? = null,
) : RuntimeException(message, cause)
