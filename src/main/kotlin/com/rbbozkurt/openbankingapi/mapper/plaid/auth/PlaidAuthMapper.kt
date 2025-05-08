package com.rbbozkurt.openbankingapi.mapper.plaid.auth

import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.CreatePublicTokenResponse
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenRequest
import com.rbbozkurt.openbankingapi.client.plaid.auth.dto.ExchangeTokenResponse
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthResponseDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface PlaidAuthMapper {
    // PlaidAuthRequest → CreatePublicTokenRequest
    fun toCreatePublicTokenRequest(request: PlaidAuthRequestDto): CreatePublicTokenRequest

    // CreatePublicTokenResponse → ExchangeTokenRequest
    @Mapping(source = "response.publicToken", target = "publicToken")
    fun toExchangeTokenRequest(
        response: CreatePublicTokenResponse,
        clientId: String,
        secret: String,
    ): ExchangeTokenRequest

    // ExchangeTokenResponse → PlaidAuthResponse
    fun toPlaidAuthResponse(response: ExchangeTokenResponse): PlaidAuthResponseDto
}
