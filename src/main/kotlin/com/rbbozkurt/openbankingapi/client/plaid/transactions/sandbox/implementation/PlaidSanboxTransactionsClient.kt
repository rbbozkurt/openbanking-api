package com.rbbozkurt.openbankingapi.client.plaid.transactions.sandbox.implementation

import com.rbbozkurt.openbankingapi.client.plaid.base.PlaidBaseClient
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsGetRequest
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsGetResponse
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsSyncRequest
import com.rbbozkurt.openbankingapi.client.plaid.transactions.dto.TransactionsSyncResponse
import com.rbbozkurt.openbankingapi.client.plaid.transactions.interfaces.PlaidTransactionsClient
import com.rbbozkurt.openbankingapi.config.plaid.PlaidProperties
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
@Qualifier("plaidSandboxTransactionsClient")
class PlaidSanboxTransactionsClient(
    @Qualifier("plaidSandboxWebClient") override val webClient: WebClient,
    override val plaidProperties: PlaidProperties,
) : PlaidBaseClient(webClient, plaidProperties), PlaidTransactionsClient {
    override fun syncTransactions(request: TransactionsSyncRequest): Mono<TransactionsSyncResponse> {
        return post(
            plaidProperties.sandbox.endpoint.transactionsSync,
            request,
            TransactionsSyncResponse::class.java,
        )
    }

    override fun getTransactions(request: TransactionsGetRequest): Mono<TransactionsGetResponse> {
        return post(
            plaidProperties.sandbox.endpoint.transactionsGet,
            request,
            TransactionsGetResponse::class.java,
        )
    }
}
