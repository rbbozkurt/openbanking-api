package com.rbbozkurt.openbankingapi.controller.plaid.error

import com.rbbozkurt.openbankingapi.client.plaid.exception.PlaidClientException
import com.rbbozkurt.openbankingapi.dto.plaid.error.PlaidErrorResponseDto
import com.rbbozkurt.openbankingapi.service.plaid.exception.PlaidServiceException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class PlaidExceptionHandler {
    private val logger = LoggerFactory.getLogger(PlaidExceptionHandler::class.java)

    @ExceptionHandler(PlaidClientException::class)
    fun handlePlaidClientException(ex: PlaidClientException): Mono<ResponseEntity<PlaidErrorResponseDto>> {
        val responseBody =
            PlaidErrorResponseDto(
                "Plaid Auth Error",
                ex.statusCode,
                ex.details,
            )
        logger.error(responseBody.toString())
        return Mono.just(ResponseEntity.status(ex.statusCode).body(responseBody))
    }

    @ExceptionHandler(PlaidServiceException::class)
    fun handlePlaidServiceException(ex: PlaidServiceException): Mono<ResponseEntity<PlaidErrorResponseDto>> {
        val responseBody =
            PlaidErrorResponseDto(
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.details,
            )
        logger.error(responseBody.toString())
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody))
    }
}
