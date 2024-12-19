package com.sh.parkingmanagement.core.domain.parkingevent

import com.sh.parkingmanagement.core.domain.common.BaseTimeEntity
import com.sh.parkingmanagement.core.domain.lot.LotEntity
import com.sh.parkingmanagement.core.domain.user.UserEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "parking_events")
class ParkingEventEntity(
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userEntity: UserEntity,

    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false)
    val lotEntity: LotEntity,

    val carNumber: String,
    val inTime: LocalDateTime,
    outTime: LocalDateTime? = null,
    totalFee: Int = 0
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var outTime = outTime
        protected set

    var totalFee = totalFee
        protected set
}