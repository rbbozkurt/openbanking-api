package com.rbbozkurt.openbankingapi.service.creditscore.interfaces

import com.rbbozkurt.openbankingapi.model.creditscore.CreditScore

interface CreditScoreService {
    fun getCreditScore(userId: String): CreditScore?
}