package com.rbbozkurt.openbankingapi.dto.creditscore

import com.rbbozkurt.openbankingapi.dto.BaseResponseDto
import com.rbbozkurt.openbankingapi.model.creditscore.CreditScore

data class CreditScoreResponseDto(
    override val path: String,
    override val message: String,
    override val data: CreditScoreData?
) : BaseResponseDto<CreditScoreResponseDto.CreditScoreData>(
    path = path,
    message = message,
    data = data
) {
    data class CreditScoreData(
        val userId: String,
        val score: Int
    ) {
        companion object {
            fun fromCreditScore(creditScore: CreditScore?): CreditScoreData? {
                return creditScore?.let {
                    CreditScoreData(
                        userId = it.userId,
                        score = it.score.value
                    )
                }
            }
        }
    }

    companion object {
        fun success(): Builder = Builder()
    }

    class Builder {
        private var path: String = "/"
        private var message: String = "Credit score retrieved successfully"
        private var data: CreditScoreData? = null

        fun withData(creditScore: CreditScore?) = apply { 
            this.data = CreditScoreData.fromCreditScore(creditScore)
        }

        fun atEndpoint(path: String) = apply { this.path = path }

        fun withMessage(message: String) = apply { this.message = message }

        fun build(): CreditScoreResponseDto {
            return CreditScoreResponseDto(
                path = path,
                message = message,
                data = data
            )
        }
    }
}
