package com.yazan98.destiny.server.config

import com.yazan98.destiny.server.data.repository.ProfileRepository
import io.vortex.spring.boot.base.config.security.VortexJwtConfigurer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:28 PM
 */

@Configuration
open class TokenConfigure @Autowired constructor(userRepository: ProfileRepository) : VortexJwtConfigurer(TokenProvider(userRepository)) {

}