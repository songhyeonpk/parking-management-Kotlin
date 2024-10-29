package com.sh.parkingmanagement.core.exception

import com.sh.parkingmanagement.core.exception.errorcode.BaseErrorCode

open class BaseCustomException(
    val errorCode: BaseErrorCode
) : RuntimeException()