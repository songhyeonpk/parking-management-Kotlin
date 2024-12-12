package com.sh.parkingmanagement.core.domain.lot

import com.sh.parkingmanagement.core.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "lots")
class LotEntity(
    name: String,
    description: String,
    address: String,
    totalCapacity: Int,
    roundAboutTime: Int,
    fee: Int,
    unitTime: Int,
    maxFee: Int
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var name = name
        protected set
    var description = description
        protected set
    var address = address
        protected set

    // 총 주차 가능 수
    var totalCapacity = totalCapacity
        protected set

    // 회차 시간
    var roundAboutTime = roundAboutTime
        protected set

    // 요금
    var fee = fee
        protected set

    // 단위시간 (요금)
    var unitTime = unitTime
        protected set

    // 최대 요금
    var maxFee = maxFee
        protected set
}