package com.sh.parkingmanagement.core.exception.errorcode

import org.springframework.http.HttpStatus

interface BaseErrorCode {
    fun getStatus(): HttpStatus
    fun getMessage(): String
}