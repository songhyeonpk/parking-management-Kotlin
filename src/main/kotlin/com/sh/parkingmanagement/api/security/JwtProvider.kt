package com.sh.parkingmanagement.api.security

import com.sh.parkingmanagement.core.enums.TimeUnit
import com.sh.parkingmanagement.core.exception.AuthCustomException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey
import kotlin.Exception

@Component
class JwtProvider(jwtProperties: JwtProperties) {

    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
        const val REFRESH_HEADER = "Refresh"
        const val BEARER_PREFIX = "Bearer "
    }

    private final val secret: String = jwtProperties.secret
    private final val secretKey: SecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))
    private final var accessTokenLifetime = 0L
    private final var refreshTokenLifetime = 0L

    init {
        val tokenLifetimes = jwtProperties.tokenLifetime
        val accessTokenLifetimeType = TimeUnit.valueOf(tokenLifetimes.accessToken.type)
        val refreshTokenLifetimeType = TimeUnit.valueOf(tokenLifetimes.refreshToken.type)
        accessTokenLifetime = accessTokenLifetimeType.getLifetimeMilli(tokenLifetimes.accessToken.duration)
        refreshTokenLifetime = refreshTokenLifetimeType.getLifetimeMilli(tokenLifetimes.refreshToken.duration)
    }

    // AccessToken 발급
    fun generateAccessToken(userId: Long, role: String): String {
        return Jwts.builder()
            .subject(userId.toString())
            .claim("role", role)
            .issuedAt(Calendar.getInstance().time)
            .expiration(getTokenExpiration(accessTokenLifetime))
            .signWith(secretKey)
            .compact()
    }

    // RefreshToken 발급
    fun generateRefreshToken(): String {
        return Jwts.builder()
            .issuedAt(Calendar.getInstance().time)
            .expiration(getTokenExpiration(refreshTokenLifetime))
            .signWith(secretKey)
            .compact()
    }

    // 토큰 만료시간 설정
    private fun getTokenExpiration(expirationMillisecond: Long): Date =
        Date(System.currentTimeMillis() + expirationMillisecond)

    // 토큰 검증
    fun validateToken(token: String): Claims {
        try {
            return parseClaims(token)
        } catch (ex: Exception) {
            when (ex) {
                is MalformedJwtException, is UnsupportedJwtException -> throw AuthCustomException.INVALID_TOKEN
                is ExpiredJwtException -> throw AuthCustomException.EXPIRED_TOKEN
                is IllegalArgumentException -> throw AuthCustomException.MISSING_TOKEN
                else -> throw ex
            }
        }
    }

    // 토큰 복호화
    private fun parseClaims(token: String): Claims {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
    }
}