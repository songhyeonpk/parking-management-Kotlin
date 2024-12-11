package com.sh.parkingmanagement.api.controller

import com.sh.parkingmanagement.core.domain.lot.LotService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/lots")
class LotController(
    private val lotService: LotService
) {
}