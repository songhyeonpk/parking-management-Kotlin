package com.sh.parkingmanagement.core.domain.parkingevent

import org.springframework.data.jpa.repository.JpaRepository

interface ParkingEventRepository : JpaRepository<ParkingEventEntity, Long> {
}