package com.yazan98.destiny.server.config

import com.yazan98.destiny.server.data.repository.ProfileRepository
import com.yazan98.destiny.server.service.UserService
import io.vortex.spring.boot.base.config.security.VortexTokenProvider
import io.vortex.spring.boot.base.models.VortexTokenDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:24 PM
 */

@Component
class TokenProvider @Autowired constructor(private val userRepository: ProfileRepository): VortexTokenProvider<UserService>() {

    override fun getTokenDetails(): VortexTokenDetails {
        return VortexTokenDetails(
                "Yazan",
                1213515L
        )
    }

    override fun getUserService(): UserService {
        return UserService(userRepository)
    }

}