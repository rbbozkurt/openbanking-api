package com.rbbozkurt.openbankingapi.controller.plaid.auth.error
import com.rbbozkurt.openbankingapi.client.plaid.auth.exception.PlaidAuthClientException
import com.rbbozkurt.openbankingapi.dto.plaid.auth.PlaidAuthErrorResponseDto
import com.rbbozkurt.openbankingapi.service.plaid.auth.exception.PlaidAuthServiceException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class PlaidAuthExceptionHandler {
    private val logger = LoggerFactory.getLogger(PlaidAuthExceptionHandler::class.java)

    @ExceptionHandler(PlaidAuthClientException::class)
    fun handlePlaidAuthClientException(ex: PlaidAuthClientException): Mono<ResponseEntity<PlaidAuthErrorResponseDto>> {
        val responseBody =
            PlaidAuthErrorResponseDto(
                "Plaid Auth Error",
                ex.statusCode,
                ex.details,
            )
        logger.error(responseBody.toString())
        return Mono.just(ResponseEntity.status(ex.statusCode).body(responseBody))
    }

    @ExceptionHandler(PlaidAuthServiceException::class)
    fun handlePlaidAuthServiceException(ex: PlaidAuthServiceException): Mono<ResponseEntity<PlaidAuthErrorResponseDto>> {
        val responseBody =
            PlaidAuthErrorResponseDto(
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.details,
            )
        logger.error(responseBody.toString())
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody))
    }
}
