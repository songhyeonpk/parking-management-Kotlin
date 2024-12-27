package com.sh.parkingmanagement.core.exception

import com.sh.parkingmanagement.core.exception.errorcode.AuthErrorCode

class AuthCustomException(
    authErrorCode: AuthErrorCode
) : BaseCustomException(authErrorCode) {

    companion object {
        val INVALID_TOKEN = AuthCustomException(AuthErrorCode.INVALID_TOKEN)
        val EXPIRED_TOKEN = AuthCustomException(AuthErrorCode.EXPIRED_TOKEN)
        val MISSING_TOKEN = AuthCustomException(AuthErrorCode.MISSING_TOKEN)
        val TOKEN_REFRESH_FAILED = AuthCustomException(AuthErrorCode.TOKEN_REFRESH_FAILED)
        val INVALID_CREDENTIALS = AuthCustomException(AuthErrorCode.INVALID_CREDENTIALS)
        val UNAUTHORIZED_ACCESS = AuthCustomException(AuthErrorCode.UNAUTHORIZED_ACCESS)
        val INSUFFICIENT_PERMISSIONS = AuthCustomException(AuthErrorCode.INSUFFICIENT_PERMISSIONS)
        val INVALID_AUTHORIZATION_HEADER = AuthCustomException(AuthErrorCode.INVALID_AUTHORIZATION_HEADER)
        val INVALID_OAUTH_PROVIDER = AuthCustomException(AuthErrorCode.INVALID_OAUTH_PROVIDER)
    }
}