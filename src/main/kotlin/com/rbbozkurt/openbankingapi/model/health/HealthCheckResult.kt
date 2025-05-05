package com.rbbozkurt.openbankingapi.model.health

data class HealthCheckResult(
    val name: String,
    val isHealthy: Boolean,
    val message: String,
)
