package com.sh.parkingmanagement.api.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secret: String = "",
    var tokenLifetime: TokenLifetime = TokenLifetime()
) {
    data class TokenLifetime(
        var accessToken: Lifetime = Lifetime(),
        var refreshToken: Lifetime = Lifetime()
    )

    data class Lifetime(
        var type: String = "",
        var duration: Long = 0
    )
}