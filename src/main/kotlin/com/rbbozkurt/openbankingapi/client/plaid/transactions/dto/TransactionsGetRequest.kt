package com.rbbozkurt.openbankingapi.client.plaid.transactions.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionsGetRequest(
    @JsonProperty("client_id")
    val clientId: String,
    val secret: String,
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("start_date")
    val startDate: String, // YYYY-MM-DD
    @JsonProperty("end_date")
    val endDate: String, // YYYY-MM-DD
    val options: TransactionsGetOptions? = null,
)

data class TransactionsGetOptions(
    @JsonProperty("account_ids")
    val accountIds: List<String>? = null,
    val count: Int? = null,
    val offset: Int? = null,
    @JsonProperty("include_original_description")
    val includeOriginalDescription: Boolean? = null,
    @JsonProperty("days_requested")
    val daysRequested: Int? = null,
)
