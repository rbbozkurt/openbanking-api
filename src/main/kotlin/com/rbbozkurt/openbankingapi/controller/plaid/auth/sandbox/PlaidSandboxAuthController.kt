package com.rbbozkurt.openbankingapi.controller.plaid.auth.sandbox

import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthResponseDto
import com.rbbozkurt.openbankingapi.service.plaid.auth.interfaces.PlaidAuthService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/plaid/auth/sandbox")
class PlaidSandboxAuthController(
    @Qualifier("plaidSandboxAuthService")
    private val plaidAuthService: PlaidAuthService,
) {
    @PostMapping
    fun authenticate(
        @RequestBody request: PlaidAuthRequestDto,
    ): Mono<PlaidAuthResponseDto> {
        return plaidAuthService.authenticateSandbox(request)
    }
}
