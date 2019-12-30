package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.ProfileRepository
import com.yazan98.destiny.server.error.AttrMissingDetails
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
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
open class ProfileService @Autowired constructor(private val repo: ProfileRepository) : BaseService<String, Profile, ProfileRepository>() {
    override fun create(entity: Profile): Profile {
        return when {
            entity.image.isEmpty() -> throw VortexInvalidValueException("User Image Required", AttrMissingDetails("Image", "Attribute Missing"))
            entity.email.isEmpty() -> throw VortexInvalidValueException("User Email Required", AttrMissingDetails("Email", "Attribute Missing"))
            entity.username.isEmpty() -> throw VortexInvalidValueException("User Username Required", AttrMissingDetails("Username", "Attribute Missing"))
            entity.password.isEmpty() -> throw VortexInvalidValueException("User Password Required", AttrMissingDetails("Password", "Attribute Missing"))
            entity.phoneNumber.isEmpty() -> throw VortexInvalidValueException("User PhoneNumber Required", AttrMissingDetails("PhoneNumber", "Attribute Missing"))
            else -> {
                getRepository().findById(entity.id).get()
            }
        }
    }

    override fun getRepository(): ProfileRepository {
        return repo
    }

    override fun update(entity: Profile): Profile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}