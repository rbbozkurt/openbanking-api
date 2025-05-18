package com.rbbozkurt.openbankingapi.service.plaid.exception

import com.rbbozkurt.openbankingapi.client.plaid.exception.PlaidClientException

object PlaidClientExceptionHandler {
    @JvmStatic
    fun toServiceException(ex: PlaidClientException): PlaidServiceException {
        return PlaidServiceException(
            message = "Plaid Client Error",
            statusCode = ex.statusCode,
            details = ex.details,
        )
    }
}
