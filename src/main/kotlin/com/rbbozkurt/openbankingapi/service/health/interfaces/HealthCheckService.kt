package com.rbbozkurt.openbankingapi.service.health.interfaces

import com.rbbozkurt.openbankingapi.model.health.HealthCheckResult

interface HealthCheckService {
    fun checkAll(): List<HealthCheckResult>
}
