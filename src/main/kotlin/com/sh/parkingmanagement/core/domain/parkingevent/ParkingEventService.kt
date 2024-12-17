package com.sh.parkingmanagement.core.domain.parkingevent

import org.springframework.stereotype.Service

@Service
class ParkingEventService(
    private val parkingEventRepository: ParkingEventRepository
) {
}