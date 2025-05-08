package com.rbbozkurt.openbankingapi.client.plaid.interfaces.auth

import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.CreatePublicTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.CreatePublicTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.ExchangeTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.dto.auth.ExchangeTokenResponse
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
