package com.rbbozkurt.openbankingapi.service.plaid.auth.interfaces

import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthResponseDto
import reactor.core.publisher.Mono

interface PlaidAuthService {
    /**
     * Performs the full sandbox auth flow:
     * 1. Creates a public token
     * 2. Exchanges it for an access token
     *
     * @param request includes client_id, secret, institution_id, initial_products
     * @return access_token and the public_token used
     */
    fun authenticateSandbox(request: PlaidAuthRequestDto): Mono<PlaidAuthResponseDto>
}
