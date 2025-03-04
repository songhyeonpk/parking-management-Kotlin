package com.sh.parkingmanagement.core.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findUserEntityBySocialProviderAndSocialId(
        socialProvider: String,
        socialId: String
    ): UserEntity?
}