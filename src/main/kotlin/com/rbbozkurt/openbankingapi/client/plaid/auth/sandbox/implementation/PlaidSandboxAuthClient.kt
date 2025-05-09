package com.rbbozkurt.openbankingapi.client.plaid.auth.sandbox.implementation

import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.auth.exception.PlaidAuthClientException
import com.rbbozkurt.openbankingapi.client.plaid.auth.interfaces.PlaidAuthClient
import com.rbbozkurt.openbankingapi.config.plaid.PlaidProperties
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
@Qualifier("plaidSandboxAuthClient")
class PlaidSandboxAuthClient(
    val plaidProperties: PlaidProperties,
) : PlaidAuthClient {
    private val webClient: WebClient =
        WebClient.builder()
            .baseUrl(plaidProperties.sandbox.baseUrl)
            .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .build()

    override fun createSandboxPublicToken(request: CreatePublicTokenRequest): Mono<CreatePublicTokenResponse> {
        return webClient.post()
            .uri(plaidProperties.sandbox.endpoint.publicTokenCreate)
            .bodyValue(request)
            .retrieve()
            .onStatus({ it.isError }) { response ->
                handlePlaidApiError(response)
            }
            .bodyToMono(CreatePublicTokenResponse::class.java)
    }

    override fun exchangePublicToken(request: ExchangeTokenRequest): Mono<ExchangeTokenResponse> {
        return webClient.post()
            .uri(plaidProperties.sandbox.endpoint.publicTokenExchange)
            .bodyValue(request)
            .retrieve()
            .onStatus({ it.isError }) { response ->
                handlePlaidApiError(response)
            }
            .bodyToMono(ExchangeTokenResponse::class.java)
    }

    private fun handlePlaidApiError(response: ClientResponse): Mono<Throwable> {
        return response.bodyToMono(String::class.java).flatMap { errorBody ->
            Mono.error(
                PlaidAuthClientException(
                    "Plaid API error: ${response.statusCode()}",
                    response.statusCode(),
                    details = errorBody,
                ),
            )
        }
    }
}
