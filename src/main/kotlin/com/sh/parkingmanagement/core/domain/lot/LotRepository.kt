package com.sh.parkingmanagement.core.domain.lot

import org.springframework.data.jpa.repository.JpaRepository

interface LotRepository : JpaRepository<LotEntity, Long> {
}