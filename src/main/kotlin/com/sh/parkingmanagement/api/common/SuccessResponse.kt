package com.sh.parkingmanagement.api.common

import org.springframework.http.HttpStatus

enum class SuccessResponse(
    val status: HttpStatus,
    val message: String
) {
    SUCCESS(HttpStatus.OK, "Request was successful"),
    CREATED(HttpStatus.CREATED, "Resource was created successfully"),
    UPDATED(HttpStatus.OK, "Resource was updated successfully"),
    DELETED(HttpStatus.OK, "Resource was deleted successfully")
}