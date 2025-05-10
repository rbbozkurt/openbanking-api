package com.rbbozkurt.openbankingapi.client.plaid.base

import com.rbbozkurt.openbankingapi.client.plaid.utils.PlaidErrorHandler
import com.rbbozkurt.openbankingapi.config.plaid.PlaidProperties
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

abstract class PlaidBaseClient(
    protected open val webClient: WebClient,
    protected open val plaidProperties: PlaidProperties,
) {
    protected fun <T> post(
        uri: String,
        body: Any,
        responseType: Class<T>,
    ): Mono<T> {
        return webClient.post()
            .uri(uri)
            .bodyValue(body)
            .retrieve()
            .onStatus({ it.isError }, PlaidErrorHandler::handlePlaidApiError)
            .bodyToMono(responseType)
    }
}
