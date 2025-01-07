package com.sh.parkingmanagement.api.security

import com.sh.parkingmanagement.core.domain.user.UserRepository
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class PrincipalDetailsService(
    private val userRepository: UserRepository
) : DefaultOAuth2UserService() {

    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User: OAuth2User = super.loadUser(userRequest)

        val registrationId = userRequest.clientRegistration.registrationId.uppercase()
        val socialId = oAuth2User.attributes["id"].toString()

        val user = userRepository.findUserEntityBySocialProviderAndSocialId(registrationId, socialId)

        return PrincipalDetails(
            userId = user?.id,
            socialProvider = registrationId,
            socialId = socialId,
            role = user?.role,
            attributes = oAuth2User.attributes
        )
    }
}