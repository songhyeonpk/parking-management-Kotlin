package com.sh.parkingmanagement.api.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class BaseApiResponse<D>(
    val message: String,
    val data: D? = null
) {
    companion object {

        // 성공 응답 (응답 데이터가 없는 경우)
        fun success(successResponse: SuccessResponse): ResponseEntity<BaseApiResponse<Nothing?>> =
            ResponseEntity(BaseApiResponse(successResponse.message), successResponse.status)

        // 성공 응답 (응답 데이터가 있는 경우)
        fun <D> success(successResponse: SuccessResponse, data: D): ResponseEntity<BaseApiResponse<D>> =
            ResponseEntity(BaseApiResponse(successResponse.message, data), successResponse.status)

        // 실패, 에러 응답 (응답 데이터가 없는 경우)
        fun error(status: HttpStatus, message: String): ResponseEntity<BaseApiResponse<Nothing?>> =
            ResponseEntity(BaseApiResponse(message), status)

        // 실패, 에러 응답 (응답 데이터가 있는 경우)
        fun <D> error(status: HttpStatus, message: String, data: D): ResponseEntity<BaseApiResponse<D>> =
            ResponseEntity(BaseApiResponse(message, data), status)

    }
}