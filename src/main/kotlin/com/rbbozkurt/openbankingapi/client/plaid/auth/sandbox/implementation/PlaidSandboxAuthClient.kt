package com.rbbozkurt.openbankingapi.client.plaid.sandbox.implementation

import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.CreatePublicTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.CreatePublicTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.ExchangeTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.ExchangeTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.interfaces.auth.PlaidAuthClient
import com.rbbozkurt.openbankingapi.config.plaid.PlaidProperties
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class PlaidSandboxAuthClient(
    plaidProperties: PlaidProperties,
) : PlaidAuthClient {
    private val webClient: WebClient =
        WebClient.builder()
            .baseUrl(plaidProperties.sandboxBaseUrl)
            .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .build()

    override fun createSandboxPublicToken(request: CreatePublicTokenRequest): Mono<CreatePublicTokenResponse> {
        return webClient.post()
            .uri("/sandbox/public_token/create")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(CreatePublicTokenResponse::class.java)
    }

    override fun exchangePublicToken(request: ExchangeTokenRequest): Mono<ExchangeTokenResponse> {
        return webClient.post()
            .uri("/item/public_token/exchange")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(ExchangeTokenResponse::class.java)
    }
}
