package com.rbbozkurt.openbankingapi.service.health.interfaces

import com.rbbozkurt.openbankingapi.model.health.HealthCheckResult

interface HealthIndicator {
    val indicatorName: String

    fun isHealthy(): HealthCheckResult
}
