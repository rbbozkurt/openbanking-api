package com.rbbozkurt.openbankingapi.service.health.implementation

import com.rbbozkurt.openbankingapi.model.health.HealthCheckResult
import com.rbbozkurt.openbankingapi.service.health.interfaces.HealthCheckService
import com.rbbozkurt.openbankingapi.service.health.interfaces.HealthIndicator
import org.springframework.stereotype.Service

@Service
class HealthCheckServiceImpl(
    private val indicators: List<HealthIndicator>,
) : HealthCheckService {
    override fun checkAll(): List<HealthCheckResult> {
        return indicators.map { it.isHealthy() }
    }
}
