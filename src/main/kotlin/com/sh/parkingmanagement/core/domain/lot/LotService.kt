package com.sh.parkingmanagement.core.domain.lot

import org.springframework.stereotype.Service

@Service
class LotService(
    private val lotRepository: LotRepository
) {
}