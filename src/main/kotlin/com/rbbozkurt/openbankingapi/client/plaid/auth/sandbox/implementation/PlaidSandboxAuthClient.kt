package com.rbbozkurt.openbankingapi.client.plaid.auth.sandbox.implementation

import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.auth.interfaces.PlaidAuthClient
import com.rbbozkurt.openbankingapi.client.plaid.base.PlaidBaseClient
import com.rbbozkurt.openbankingapi.config.plaid.PlaidProperties
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
@Qualifier("plaidSandboxAuthClient")
class PlaidSandboxAuthClient(
    @Qualifier("plaidSandboxWebClient") override val webClient: WebClient,
    override val plaidProperties: PlaidProperties,
) : PlaidBaseClient(webClient, plaidProperties), PlaidAuthClient {
    override fun createSandboxPublicToken(request: CreatePublicTokenRequest): Mono<CreatePublicTokenResponse> {
        return post(
            plaidProperties.sandbox.endpoint.publicTokenCreate,
            request,
            CreatePublicTokenResponse::class.java,
        )
    }

    override fun exchangePublicToken(request: ExchangeTokenRequest): Mono<ExchangeTokenResponse> {
        return post(
            plaidProperties.sandbox.endpoint.publicTokenExchange,
            request,
            ExchangeTokenResponse::class.java,
        )
    }
}
