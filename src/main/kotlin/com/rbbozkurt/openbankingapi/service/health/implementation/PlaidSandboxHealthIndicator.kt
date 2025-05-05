package com.rbbozkurt.openbankingapi.service.health.implementation

import com.rbbozkurt.openbankingapi.model.health.HealthCheckResult
import com.rbbozkurt.openbankingapi.service.health.interfaces.HealthIndicator
import org.springframework.stereotype.Component

@Component
class PlaidSandboxHealthIndicator : HealthIndicator {
    override val indicatorName: String = "Plaid Sandbox"

    override fun isHealthy(): HealthCheckResult {
        return try {
            throw UnsupportedOperationException("$indicatorName is not yet implemented.")
        } catch (ex: UnsupportedOperationException) {
            HealthCheckResult(indicatorName, false, "$indicatorName failed: ${ex.message}")
        }
    }
}
