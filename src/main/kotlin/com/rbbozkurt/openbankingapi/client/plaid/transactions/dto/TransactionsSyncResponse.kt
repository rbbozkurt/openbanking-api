package com.rbbozkurt.openbankingapi.client.plaid.transactions.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionsSyncResponse(
    val accounts: List<AccountSyncDto>,
    val added: List<TransactionSyncDto>,
    val modified: List<TransactionSyncDto>,
    val removed: List<RemovedTransactionDto>,
    @JsonProperty("next_cursor")
    val nextCursor: String?,
    @JsonProperty("has_more")
    val hasMore: Boolean,
    @JsonProperty("transactions_update_status")
    val transactionsUpdateStatus: String,
    @JsonProperty("request_id")
    val requestId: String,
)

data class AccountSyncDto(
    @JsonProperty("account_id")
    val accountId: String,
    val balances: AccountBalanceDto,
    val mask: String?,
    val name: String,
    @JsonProperty("official_name")
    val officialName: String?,
    val subtype: String?,
    val type: String,
)

data class AccountBalanceDto(
    val available: Double?,
    val current: Double?,
    @JsonProperty(value = "iso_currency_code")
    val isoCurrencyCode: String?,
    val limit: Double? = null,
    @JsonProperty(value = "unofficial_currency_code")
    val unofficialCurrencyCode: String? = null,
)

data class TransactionSyncDto(
    @JsonProperty("transaction_id")
    val transactionId: String,
    @JsonProperty("account_id")
    val accountId: String,
    val amount: Double,
    @JsonProperty("iso_currency_code")
    val isoCurrencyCode: String?,
    val date: String,
    val name: String,
    @JsonProperty("merchant_name")
    val merchantName: String?,
)

data class RemovedTransactionDto(
    @JsonProperty("transaction_id")
    val transactionId: String,
    @JsonProperty("account_id")
    val accountId: String,
)
