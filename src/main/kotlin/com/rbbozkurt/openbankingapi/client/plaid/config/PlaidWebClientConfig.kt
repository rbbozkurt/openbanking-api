package com.rbbozkurt.openbankingapi.client.plaid.config

import com.rbbozkurt.openbankingapi.config.plaid.PlaidProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class PlaidWebClientConfig {
    @Bean
    fun plaidSandboxWebClient(plaidProperties: PlaidProperties): WebClient {
        return WebClient.builder()
            .baseUrl(plaidProperties.sandbox.baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }
}
