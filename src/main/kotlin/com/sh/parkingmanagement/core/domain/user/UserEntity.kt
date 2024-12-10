package com.sh.parkingmanagement.core.domain.user

import com.sh.parkingmanagement.core.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Column(nullable = false)
    val socialProvider: String,

    @Column(nullable = false)
    val socialId: String,

    nickname: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    var nickname: String = nickname
        protected set
}