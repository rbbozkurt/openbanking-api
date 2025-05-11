package com.rbbozkurt.openbankingapi.controller.plaid.auth.sandbox

import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.error.PlaidErrorResponseDto
import com.rbbozkurt.openbankingapi.service.plaid.auth.interfaces.PlaidAuthService
import com.rbbozkurt.openbankingapi.service.plaid.exception.PlaidServiceException
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
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
    ): Mono<ResponseEntity<Any>> {
        return plaidAuthService.authenticateSandbox(request)
            .map { ResponseEntity.ok(it as Any) }
            .onErrorResume(PlaidServiceException::class.java) { ex ->
                val responseBody =
                    PlaidErrorResponseDto(
                        "Plaid Auth Error",
                        ex.statusCode,
                        ex.details,
                    )
                Mono.just(ResponseEntity.status(ex.statusCode).body(responseBody))
            }
    }
}
