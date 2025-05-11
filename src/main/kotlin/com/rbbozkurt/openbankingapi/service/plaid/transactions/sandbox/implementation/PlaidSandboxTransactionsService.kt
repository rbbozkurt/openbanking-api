package com.rbbozkurt.openbankingapi.service.plaid.transactions.sandbox.implementation

import com.rbbozkurt.openbankingapi.client.plaid.exception.PlaidClientException
import com.rbbozkurt.openbankingapi.client.plaid.transactions.interfaces.PlaidTransactionsClient
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsGetRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsGetResponseDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsSyncRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsSyncResponseDto
import com.rbbozkurt.openbankingapi.service.plaid.exception.PlaidClientExceptionHandler
import com.rbbozkurt.openbankingapi.service.plaid.transactions.interfaces.PlaidTransactionsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
@Qualifier("plaidSandboxTransactionsService")
class PlaidSandboxTransactionsService(
    @Qualifier("plaidSandboxTransactionsClient")
    val transactionsClient: PlaidTransactionsClient,
) : PlaidTransactionsService {
    override fun getTransactions(request: PlaidTransactionsGetRequestDto): Mono<PlaidTransactionsGetResponseDto> {
        return transactionsClient.getTransactions(request)
            .onErrorMap(PlaidClientException::class.java, PlaidClientExceptionHandler::toServiceException)
    }

    override fun syncTransactions(request: PlaidTransactionsSyncRequestDto): Mono<PlaidTransactionsSyncResponseDto> {
        return transactionsClient.syncTransactions(request)
            .onErrorMap(PlaidClientException::class.java, PlaidClientExceptionHandler::toServiceException)
    }
}
