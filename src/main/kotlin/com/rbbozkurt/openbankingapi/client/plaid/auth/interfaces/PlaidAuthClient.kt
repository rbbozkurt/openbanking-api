package com.rbbozkurt.openbankingapi.client.plaid.auth.interfaces

import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenResponse
import reactor.core.publisher.Mono

interface PlaidAuthClient {
    /**
     * Creates a public token in the sandbox environment.
     */
    fun createSandboxPublicToken(request: CreatePublicTokenRequest): Mono<CreatePublicTokenResponse>

    /**
     * Exchanges a public token for an access token.
     */
    fun exchangePublicToken(request: ExchangeTokenRequest): Mono<ExchangeTokenResponse>
}
