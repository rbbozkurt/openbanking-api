package com.rbbozkurt.openbankingapi.model.creditscore

data class CreditScoreValue(val value: Int)

data class CreditScore(
    val userId: String,
    val score: CreditScoreValue
)
