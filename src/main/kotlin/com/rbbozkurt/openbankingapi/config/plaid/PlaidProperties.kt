package com.rbbozkurt.openbankingapi.config.plaid

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "plaid")
class PlaidProperties {
    val sandbox: SandboxProperties = SandboxProperties()

    class SandboxProperties {
        lateinit var baseUrl: String
        val endpoint: EndpointProperties = EndpointProperties()
    }

    class EndpointProperties {
        lateinit var publicTokenCreate: String
        lateinit var publicTokenExchange: String
    }
}
