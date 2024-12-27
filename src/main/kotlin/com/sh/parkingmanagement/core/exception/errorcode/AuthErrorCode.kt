package com.sh.parkingmanagement.core.exception.errorcode

import org.springframework.http.HttpStatus

enum class AuthErrorCode(
    private val status: HttpStatus,
    private val message: String
) : BaseErrorCode {
    // 유효하지 않은 토큰
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰"),

    // 만료된 토큰
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰 정보"),

    // 토큰 누락
    MISSING_TOKEN(HttpStatus.BAD_REQUEST, "토큰 정보 누락"),

    // 토큰 갱신 실패 ( 유효하지 않은 리프레시 토큰 )
    TOKEN_REFRESH_FAILED(HttpStatus.BAD_REQUEST, "토큰 갱신 실패"),

    // 유효하지 않은 자격 증명, 인증 ( 인증 실패 )
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "자격 증명, 인증 실패"),

    // 접근 권한 없음 ( 인증되지 않은 사용자가 인증이 필요한 리소스에 접근할 경우 )
    UNAUTHORIZED_ACCESS(HttpStatus.FORBIDDEN, "인증되지 않아 접근 권한 없음"),

    // 권한 부족 ( 인증은 성공했지만 접근 권한이 부족한 경우, ex. 일반 사용자가 관리자 페이지에 접근 요청할 경우 )
    INSUFFICIENT_PERMISSIONS(HttpStatus.FORBIDDEN, "인증은 되었지만 접근 권한 부족"),

    // 유효하지 않은 Authorization Header ( Authorization Header 누락 )
    INVALID_AUTHORIZATION_HEADER(HttpStatus.UNAUTHORIZED, "유효하지 않은 인증, 인가 헤더 정보"),

    // 유효하지 않은 OAuth 제공자
    INVALID_OAUTH_PROVIDER(HttpStatus.FORBIDDEN, "유효하지 않은 OAuth 제공자");

    override fun getStatus() = status
    override fun getMessage() = message
}