package com.rbbozkurt.openbankingapi.service.creditscore.implementation

import com.rbbozkurt.openbankingapi.model.creditscore.CreditScore
import com.rbbozkurt.openbankingapi.model.creditscore.CreditScoreValue
import com.rbbozkurt.openbankingapi.service.creditscore.interfaces.CreditScoreService
import org.springframework.stereotype.Service

@Service
class CreditScoreServiceImpl : CreditScoreService {
    override fun getCreditScore(userId: String): CreditScore? {
        return if (userId.isNotBlank()) {
            CreditScore(
                userId = userId,
                score = CreditScoreValue((0..100).random()), // Random score between 0 and 100 for now
            )
        } else {
            null
        }
    }
}
