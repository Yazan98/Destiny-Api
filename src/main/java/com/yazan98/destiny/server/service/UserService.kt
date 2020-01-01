package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.repository.ProfileRepository
import io.vortex.spring.boot.base.errors.VortexAuthException
import io.vortex.spring.boot.base.models.TokenErrorDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:25 PM
 */

@Component
open class UserService @Autowired constructor(private val repo: ProfileRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        try {
            return repo.findByName(username).get()
        } catch (ex: NoSuchElementException) {
            throw VortexAuthException("User Not Found By This Token For $username" , TokenErrorDetails("Username Not Found"))
        }
    }

}
