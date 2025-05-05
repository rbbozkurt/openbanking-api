package com.rbbozkurt.openbankingapi.controller.health

import com.rbbozkurt.openbankingapi.dto.health.HealthStatusResponseDto
import com.rbbozkurt.openbankingapi.service.health.interfaces.HealthCheckService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController(
    private val healthCheckService: HealthCheckService,
) {
    @GetMapping("/health")
    fun health(request: HttpServletRequest): ResponseEntity<HealthStatusResponseDto> {
        val healthChecks = healthCheckService.checkAll()
        val isAllHealthy = healthChecks.all { it.isHealthy }

        val responseBuilder =
            if (isAllHealthy) {
                HealthStatusResponseDto.serviceAvailable()
                    .withMessage("Service is up and running")
            } else {
                HealthStatusResponseDto.serviceUnavailable()
                    .withMessage("One or more services are down")
            }

        val response =
            responseBuilder
                .atEndpoint(request.requestURI)
                .withData(healthChecks)
                .build()

        val httpStatus = if (isAllHealthy) 200 else 503
        return ResponseEntity.status(httpStatus).body(response)
    }
}
