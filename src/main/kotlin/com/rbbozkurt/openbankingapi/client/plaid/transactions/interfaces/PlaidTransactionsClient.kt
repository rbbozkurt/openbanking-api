package com.rbbozkurt.openbankingapi.client.plaid.transactions.interfaces

import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsGetRequest
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsGetResponse
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsSyncRequest
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsSyncResponse
import reactor.core.publisher.Mono

interface PlaidTransactionsClient {
    /**
     * Calls the Plaid /transactions/sync endpoint.
     *
     * @param request The request payload containing client_id, secret, access_token, etc.
     * @return A Mono emitting the TransactionsSyncResponse from Plaid.
     */
    fun syncTransactions(request: TransactionsSyncRequest): Mono<TransactionsSyncResponse>

    /**
     * Calls the Plaid /transactions/get endpoint.
     *
     * @param request The request payload containing client_id, secret, access_token, start_date, end_date, etc.
     * @return A Mono emitting the TransactionsGetResponse from Plaid.
     */
    fun getTransactions(request: TransactionsGetRequest): Mono<TransactionsGetResponse>
}
