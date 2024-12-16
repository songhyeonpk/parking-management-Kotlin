package com.sh.parkingmanagement.api.controller

import com.sh.parkingmanagement.api.docs.ParkingEventApiSpec
import com.sh.parkingmanagement.core.domain.parkingevent.ParkingEventService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/parking-events")
class ParkingEventController(
    private val parkingEventService: ParkingEventService
) : ParkingEventApiSpec {
}