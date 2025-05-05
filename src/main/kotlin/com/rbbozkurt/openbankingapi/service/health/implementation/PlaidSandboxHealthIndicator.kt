package com.rbbozkurt.openbankingapi.service.health.implementation

import com.rbbozkurt.openbankingapi.model.health.HealthCheckResult
import com.rbbozkurt.openbankingapi.service.health.interfaces.HealthIndicator
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(
    name = ["health.plaid.sandbox.enabled"],
    havingValue = "true",
    matchIfMissing = false,
)
class PlaidSandboxHealthIndicator : HealthIndicator {
    override val indicatorName: String = "Plaid Sandbox"

    override fun isHealthy(): HealthCheckResult {
        return try {
            throw NotImplementedError("$indicatorName is not yet implemented.")
        } catch (ex: NotImplementedError) {
            HealthCheckResult(indicatorName, false, "$indicatorName failed: ${ex.message}")
        }
    }
}
