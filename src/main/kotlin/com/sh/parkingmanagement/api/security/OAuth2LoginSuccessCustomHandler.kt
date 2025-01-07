package com.sh.parkingmanagement.api.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component

/**
 * OAuth2 로그인 성공 시 동작하는 핸들러
 * PrincipalDetailsService loadUser() 함수 호출 이후 실행
 */
@Component
class OAuth2LoginSuccessCustomHandler(
    private val jwtProvider: JwtProvider
) : AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        TODO("인증에 성공한 OAuth2 회원의 PrincipalDetails 정보를 기반으로 해당 회원이 서비스에 가입된 회원이면 JWT 응답하고 로그인 처리, 아닌 경우 OAuth2 정보를 응답하고 회원가입 필요 응답")
    }
}