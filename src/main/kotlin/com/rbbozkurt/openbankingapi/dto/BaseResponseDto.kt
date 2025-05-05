package com.rbbozkurt.openbankingapi.dto

import java.time.ZonedDateTime

open class BaseResponseDto<T>(
    val timestamp: ZonedDateTime = ZonedDateTime.now(),
    open val path: String,
    open val message: String,
    open val data: T? = null,
)
