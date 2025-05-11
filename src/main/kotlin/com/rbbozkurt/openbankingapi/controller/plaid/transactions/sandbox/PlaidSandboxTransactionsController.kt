package com.rbbozkurt.openbankingapi.controller.plaid.transactions.sandbox

import com.rbbozkurt.openbankingapi.dto.plaid.error.PlaidErrorResponseDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsGetRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsSyncRequestDto
import com.rbbozkurt.openbankingapi.service.plaid.exception.PlaidServiceException
import com.rbbozkurt.openbankingapi.service.plaid.transactions.interfaces.PlaidTransactionsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/plaid/transactions/sandbox")
class PlaidSandboxTransactionsController(
    @Qualifier("plaidSandboxTransactionsService")
    private val plaidTransactionsService: PlaidTransactionsService,
) {
    @PostMapping("/sync")
    fun syncTransactions(
        @RequestBody request: PlaidTransactionsSyncRequestDto,
    ): Mono<ResponseEntity<Any>> {
        return handleRequest { plaidTransactionsService.syncTransactions(request) }
    }

    @PostMapping("/get")
    fun getTransactions(
        @RequestBody request: PlaidTransactionsGetRequestDto,
    ): Mono<ResponseEntity<Any>> {
        return handleRequest { plaidTransactionsService.getTransactions(request) }
    }

    private fun <T> handleRequest(serviceCall: () -> Mono<T>): Mono<ResponseEntity<Any>> {
        return serviceCall()
            .map { ResponseEntity.ok(it as Any) }
            .onErrorResume(PlaidServiceException::class.java) { ex ->
                val responseBody =
                    PlaidErrorResponseDto(
                        error = "Plaid Auth Error",
                        statusCode = ex.statusCode,
                        details = ex.details,
                    )
                Mono.just(ResponseEntity.status(ex.statusCode).body(responseBody))
            }
    }
}
