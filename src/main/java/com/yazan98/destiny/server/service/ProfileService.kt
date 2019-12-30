package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.ProfileRepository
import com.yazan98.destiny.server.error.AttrMissingDetails
import com.yazan98.destiny.server.response.AuthResponse
import com.yazan98.destiny.server.response.ProfileLocationResponse
import com.yazan98.destiny.server.response.ProfileResponse
import com.yazan98.destiny.server.utils.JwtTokenUtil
import io.vortex.spring.boot.base.errors.EmptyErrorDetails
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.VortexNotFoundException
import io.vortex.spring.boot.base.service.VortexMysqlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:34 AM
 */

@Service
@Transactional
open class ProfileService @Autowired constructor(private val repo: ProfileRepository , private val tokenUtils: JwtTokenUtil?)
    : BaseService<Long, Profile, ProfileRepository>() {
    override fun create(entity: Profile): Profile {
        when {
            entity.image.isEmpty() -> throw VortexInvalidValueException("User Image Required", AttrMissingDetails("Image", "Attribute Missing"))
            entity.email.isEmpty() -> throw VortexInvalidValueException("User Email Required", AttrMissingDetails("Email", "Attribute Missing"))
            entity.username.isEmpty() -> throw VortexInvalidValueException("User Username Required", AttrMissingDetails("Username", "Attribute Missing"))
            entity.password.isEmpty() -> throw VortexInvalidValueException("User Password Required", AttrMissingDetails("Password", "Attribute Missing"))
            entity.phoneNumber.isEmpty() -> throw VortexInvalidValueException("User PhoneNumber Required", AttrMissingDetails("PhoneNumber", "Attribute Missing"))
            entity.password.length < 8 -> throw VortexInvalidValueException("User Password Must Be 8 At Minimum", AttrMissingDetails("Password", "Validation"))
            else -> {
                getRepository().save(entity)
                println("ID : ${entity.id}")
            }
        }
        return getEntityById(entity.id)
    }

    override fun getEntityById(id: Long): Profile {
        try {
            return getRepository().findById(id).get()
        } catch (ex: NoSuchElementException) {
            ex.printStackTrace()
            throw VortexNotFoundException(ex.message, EmptyErrorDetails(id, ex.message))
        }
    }

    fun createNewAccount(content: Profile): AuthResponse {
        val result = create(content)
        return AuthResponse(
                "Bearer ${JwtTokenUtil().generateToken(result)}",
                ProfileResponse(
                        username = result.username,
                        image = result.image,
                        accountStatus = result.accountStatus,
                        email = result.email,
                        enabled = result.enabled,
                        location = ProfileLocationResponse(result.location.latitude, result.location.longitude),
                        phoneNumber = result.phoneNumber
                )
        )
    }

    override fun getRepository(): ProfileRepository {
        return repo
    }

    override fun update(entity: Profile): Profile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}