package com.rbbozkurt.openbankingapi.service.plaid.auth.sandbox.implementation

import com.rbbozkurt.openbankingapi.client.plaid.auth.interfaces.PlaidAuthClient
import com.rbbozkurt.openbankingapi.client.plaid.exception.PlaidClientException
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthResponseDto
import com.rbbozkurt.openbankingapi.mapper.plaid.auth.PlaidAuthMapper
import com.rbbozkurt.openbankingapi.service.plaid.auth.interfaces.PlaidAuthService
import com.rbbozkurt.openbankingapi.service.plaid.exception.PlaidClientExceptionHandler
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
@Qualifier("plaidSandboxAuthService")
class PlaidSandboxAuthService(
    @Qualifier("plaidSandboxAuthClient")
    private val plaidAuthClient: PlaidAuthClient,
    private val plaidAuthMapper: PlaidAuthMapper,
) : PlaidAuthService {
    override fun authenticateSandbox(request: PlaidAuthRequestDto): Mono<PlaidAuthResponseDto> {
        return plaidAuthClient.createSandboxPublicToken(plaidAuthMapper.toCreatePublicTokenRequest(request))
            .flatMap { pubTokenResp ->
                plaidAuthClient.exchangePublicToken(
                    plaidAuthMapper.toExchangeTokenRequest(pubTokenResp, request.clientId, request.secret),
                ).map { exchangeTokenResp ->
                    plaidAuthMapper.toPlaidAuthResponse(exchangeTokenResp, pubTokenResp.publicToken)
                }
            }
            .map { plaidAuthMapper.toPlaidAuthResponse(it) }
            .onErrorMap(PlaidClientException::class.java, PlaidClientExceptionHandler::toServiceException)
    }
}
