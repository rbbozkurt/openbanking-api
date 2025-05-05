package com.rbbozkurt.openbankingapi.dto.health

import com.rbbozkurt.openbankingapi.dto.BaseResponseDto

data class HealthStatusResponseDto(
    val status: HealthStatus,
    override val path: String,
    override val message: String,
    override val data: Any?,
) : BaseResponseDto<Any>(
        path = path,
        message = message,
        data = data,
    ) {
    companion object {
        fun serviceAvailable(): Builder = Builder(HealthStatus.UP)

        fun serviceUnavailable(): Builder = Builder(HealthStatus.DOWN)
    }

    class Builder(private var status: HealthStatus) {
        private var path: String = "/"
        private var message: String = ""
        private var data: Any? = null

        fun withStatus(status: HealthStatus) = apply { this.status = status }

        fun withData(data: Any?) = apply { this.data = data }

        fun atEndpoint(path: String) = apply { this.path = path }

        fun withMessage(message: String) = apply { this.message = message }

        fun build(): HealthStatusResponseDto {
            return HealthStatusResponseDto(
                status = status,
                path = path,
                message = message,
                data = data,
            )
        }
    }
}
