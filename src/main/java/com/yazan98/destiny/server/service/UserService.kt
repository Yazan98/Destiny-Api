package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import sun.plugin.util.UserProfile

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:25 PM
 */

@Component
open class UserService @Autowired constructor(private val repo: ProfileRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return repo.findByName(username).get()
    }

}
