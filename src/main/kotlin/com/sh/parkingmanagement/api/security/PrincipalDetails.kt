package com.sh.parkingmanagement.api.security

import com.sh.parkingmanagement.core.enums.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

class PrincipalDetails(
    val userId: Long?,
    val socialProvider: String,
    val socialId: String,
    val role: UserRole?,
    val attributes: Map<String, Any>
) : OAuth2User {

    override fun getName(): String = userId.toString()

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return setOf(SimpleGrantedAuthority(role!!.name))
    }

    override fun getAttributes(): Map<String, Any> = attributes

    fun getSocialProvider(): String = socialProvider

    fun getSocialId(): String = socialId
}