package com.rbbozkurt.openbankingapi.client.plaid.transactions.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionsGetResponse(
    val accounts: List<AccountGetDto>,
    val transactions: List<TransactionGetDto>,
    val item: ItemDto,
    @JsonProperty("total_transactions")
    val totalTransactions: Int,
    @JsonProperty("request_id")
    val requestId: String,
)

data class AccountGetDto(
    @JsonProperty("account_id")
    val accountId: String,
    val balances: BalancesDto,
    val mask: String?,
    val name: String,
    @JsonProperty("official_name")
    val officialName: String?,
    val type: String,
    val subtype: String?,
    @JsonProperty("iso_currency_code")
    val isoCurrencyCode: String?,
    @JsonProperty("unofficial_currency_code")
    val unofficialCurrencyCode: String?,
)

data class BalancesDto(
    val available: Double?,
    val current: Double?,
    val limit: Double?,
    @JsonProperty("iso_currency_code")
    val isoCurrencyCode: String?,
    @JsonProperty("unofficial_currency_code")
    val unofficialCurrencyCode: String?,
    @JsonProperty("last_updated_datetime")
    val lastUpdatedDatetime: String?,
)

data class TransactionGetDto(
    @JsonProperty("transaction_id")
    val transactionId: String,
    @JsonProperty("account_id")
    val accountId: String,
    @JsonProperty("account_owner")
    val accountOwner: String?,
    val amount: Double,
    @JsonProperty("iso_currency_code")
    val isoCurrencyCode: String?,
    @JsonProperty("unofficial_currency_code")
    val unofficialCurrencyCode: String?,
    @JsonProperty("check_number")
    val checkNumber: String?,
    val date: String,
    val datetime: String?,
    @JsonProperty("authorized_date")
    val authorizedDate: String?,
    @JsonProperty("authorized_datetime")
    val authorizedDatetime: String?,
    val location: LocationDto?,
    val name: String,
    @JsonProperty("merchant_name")
    val merchantName: String?,
    @JsonProperty("merchant_entity_id")
    val merchantEntityId: String?,
    @JsonProperty("logo_url")
    val logoUrl: String?,
    val website: String?,
    @JsonProperty("payment_channel")
    val paymentChannel: String,
    val pending: Boolean,
    @JsonProperty("pending_transaction_id")
    val pendingTransactionId: String?,
    @JsonProperty("transaction_code")
    val transactionCode: String?,
    @JsonProperty("transaction_type")
    val transactionType: String?,
    @JsonProperty("original_description")
    val originalDescription: String?,
    @JsonProperty("personal_finance_category")
    val personalFinanceCategory: PersonalFinanceCategoryDto?,
    @JsonProperty("personal_finance_category_icon_url")
    val personalFinanceCategoryIconUrl: String?,
    val counterparties: List<CounterpartyDto>?,
    @JsonProperty("payment_meta")
    val paymentMeta: PaymentMetaDto,
)

data class LocationDto(
    val address: String?,
    val city: String?,
    val region: String?,
    @JsonProperty("postal_code")
    val postalCode: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    @JsonProperty("store_number")
    val storeNumber: String?,
)

data class PersonalFinanceCategoryDto(
    val primary: String,
    val detailed: String,
    @JsonProperty("confidence_level")
    val confidenceLevel: String?,
)

data class CounterpartyDto(
    val name: String,
    val type: String,
    @JsonProperty("logo_url")
    val logoUrl: String?,
    val website: String?,
    @JsonProperty("entity_id")
    val entityId: String?,
    @JsonProperty("confidence_level")
    val confidenceLevel: String?,
)

data class PaymentMetaDto(
    @JsonProperty("reference_number")
    val referenceNumber: String?,
    @JsonProperty("ppd_id")
    val ppdId: String?,
    val payee: String?,
    @JsonProperty("by_order_of")
    val byOrderOf: String?,
    val payer: String?,
    @JsonProperty("payment_method")
    val paymentMethod: String?,
    @JsonProperty("payment_processor")
    val paymentProcessor: String?,
    val reason: String?,
)

data class ItemDto(
    @JsonProperty("item_id")
    val itemId: String,
    @JsonProperty("institution_id")
    val institutionId: String?,
    @JsonProperty("institution_name")
    val institutionName: String?,
    val webhook: String?,
    @JsonProperty("auth_method")
    val authMethod: String?,
    @JsonProperty("available_products")
    val availableProducts: List<String>,
    @JsonProperty("billed_products")
    val billedProducts: List<String>,
    @JsonProperty("consent_expiration_time")
    val consentExpirationTime: String?,
    val error: Any?,
    @JsonProperty("update_type")
    val updateType: String?,
)
