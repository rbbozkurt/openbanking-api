package com.rbbozkurt.openbankingapi.dto.health

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class HealthStatus(private val value: String) {
    UP("UP"),
    DOWN("DOWN"),
    ;

    @JsonValue
    override fun toString(): String = value

    companion object {
        @JvmStatic
        @JsonCreator
        fun fromValue(value: String): HealthStatus {
            return entries.firstOrNull { it.value.equals(value, ignoreCase = true) }
                ?: throw IllegalArgumentException("Unknown status: $value")
        }
    }
}
