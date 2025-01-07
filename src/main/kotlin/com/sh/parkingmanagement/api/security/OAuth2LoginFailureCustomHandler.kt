package com.sh.parkingmanagement.api.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component

/**
 * OAuth2 로그인 실패 시 동작하는 핸들러
 */
@Component
class OAuth2LoginFailureCustomHandler() : AuthenticationFailureHandler {

    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        TODO("OAuth2 인증에 실패했을 경우, 예외처리")
    }
}