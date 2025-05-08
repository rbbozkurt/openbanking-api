package com.rbbozkurt.openbankingapi.dto.creditscore

import com.rbbozkurt.openbankingapi.dto.BaseResponseDto
import com.rbbozkurt.openbankingapi.model.creditscore.CreditScore

data class CreditScoreResponseDto(
    override val path: String,
    override val message: String,
    override val data: CreditScore?,
) : BaseResponseDto<CreditScore>(
        path = path,
        message = message,
        data = data,
    ) {
    companion object {
        fun success(): Builder = Builder()

        fun error(): Builder = Builder().withMessage("Error retrieving credit score")
    }

    class Builder {
        private var path: String = "/"
        private var message: String = "Credit score retrieved successfully"
        private var data: CreditScore? = null

        fun withData(creditScore: CreditScore?) =
            apply {
                this.data = creditScore
            }

        fun atEndpoint(path: String) = apply { this.path = path }

        fun withMessage(message: String) = apply { this.message = message }

        fun build(): CreditScoreResponseDto {
            return CreditScoreResponseDto(
                path = path,
                message = message,
                data = data,
            )
        }
    }
}
