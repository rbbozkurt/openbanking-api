package com.rbbozkurt.openbankingapi.client.plaid.utils

import com.rbbozkurt.openbankingapi.client.plaid.exception.PlaidClientException
import org.springframework.web.reactive.function.client.ClientResponse
import reactor.core.publisher.Mono

object PlaidErrorHandler {
    fun handlePlaidApiError(response: ClientResponse): Mono<Throwable> {
        return response.bodyToMono(String::class.java).flatMap { errorBody ->

            Mono.error(
                PlaidClientException(
                    "Plaid API error: ${response.statusCode()}",
                    response.statusCode(),
                    details = errorBody,
                ),
            )
        }
    }
}
