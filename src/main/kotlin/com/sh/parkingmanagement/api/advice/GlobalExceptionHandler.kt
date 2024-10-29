package com.sh.parkingmanagement.api.advice

import com.sh.parkingmanagement.api.common.BaseApiResponse
import com.sh.parkingmanagement.core.exception.BaseCustomException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    // 커스텀 예외 핸들러
    @ExceptionHandler(BaseCustomException::class)
    fun baseCustomExceptionHandler(exception: BaseCustomException) = with(exception.errorCode) {
        BaseApiResponse.error(getStatus(), getMessage())
    }
}