package com.rbbozkurt.openbankingapi.service.plaid.transactions.interfaces

import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsGetRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsGetResponseDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsSyncRequestDto
import com.rbbozkurt.openbankingapi.dto.plaid.transactions.PlaidTransactionsSyncResponseDto
import reactor.core.publisher.Mono

interface PlaidTransactionsService {
    /**
     * Retrieves transactions using Plaid's /transactions/get endpoint.
     *
     * @param request The request payload for retrieving transactions.
     * @return A Mono emitting the TransactionsGetResponse.
     */
    fun getTransactions(request: PlaidTransactionsGetRequestDto): Mono<PlaidTransactionsGetResponseDto>

    /**
     * Retrieves transactions using Plaid's /transactions/sync endpoint.
     *
     * @param request The request payload for syncing transactions.
     * @return A Mono emitting the TransactionsSyncResponse.
     */
    fun syncTransactions(request: PlaidTransactionsSyncRequestDto): Mono<PlaidTransactionsSyncResponseDto>
}
