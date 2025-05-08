package com.rbbozkurt.openbankingapi.controller.creditscore

import com.rbbozkurt.openbankingapi.dto.creditscore.CreditScoreResponseDto
import com.rbbozkurt.openbankingapi.service.creditscore.interfaces.CreditScoreService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class CreditScoreController(
    private val creditScoreService: CreditScoreService,
) {
    @GetMapping("/{userId}/credit-score")
    fun getCreditScoreByPath(
        @PathVariable @NotBlank(message = "User ID must not be blank") userId: String,
        request: HttpServletRequest,
    ): ResponseEntity<CreditScoreResponseDto> {
        val creditScore = creditScoreService.getCreditScore(userId)

        val response =
            if (creditScore != null) {
                CreditScoreResponseDto.success()
                    .withData(creditScore)
                    .atEndpoint(request.requestURI)
                    .build()
            } else {
                CreditScoreResponseDto.success()
                    .withMessage("Credit score not found for user: $userId")
                    .atEndpoint(request.requestURI)
                    .build()
            }

        return ResponseEntity.ok(response)
    }
}
