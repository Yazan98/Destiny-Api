package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.ProfileRepository
import com.yazan98.destiny.server.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:41 AM
 */

@RestController
@RequestMapping("/api/v1/auth")
class AuthController @Autowired constructor(service: ProfileService)
    : BaseController<Profile, String, ProfileRepository, ProfileService>(service)
