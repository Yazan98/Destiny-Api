package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.body.LoginBody
import com.yazan98.destiny.server.body.PinCodeBody
import com.yazan98.destiny.server.config.MessageSenderConfiguration
import com.yazan98.destiny.server.data.entity.phone.PhoneNumber
import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.ProfileRepository
import com.yazan98.destiny.server.error.AttrMissingDetails
import com.yazan98.destiny.server.response.AuthResponse
import com.yazan98.destiny.server.response.PinCodeResponse
import com.yazan98.destiny.server.response.ProfileLocationResponse
import com.yazan98.destiny.server.response.ProfileResponse
import com.yazan98.destiny.server.utils.JwtTokenUtil
import io.vortex.spring.boot.base.errors.EmptyErrorDetails
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.VortexNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:34 AM
 */

@Service
@Transactional
open class ProfileService @Autowired constructor(
        private val repo: ProfileRepository
) : BaseService<Long, Profile, ProfileRepository>() {

    override fun create(entity: Profile): Profile {
        when {
            entity.image.isEmpty() -> throw VortexInvalidValueException("User Image Required", AttrMissingDetails("Image", "Attribute Missing"))
            entity.email.isEmpty() -> throw VortexInvalidValueException("User Email Required", AttrMissingDetails("Email", "Attribute Missing"))
            entity.username.isEmpty() -> throw VortexInvalidValueException("User Username Required", AttrMissingDetails("Username", "Attribute Missing"))
            entity.password.isEmpty() -> throw VortexInvalidValueException("User Password Required", AttrMissingDetails("Password", "Attribute Missing"))
            entity.phoneNumber.isEmpty() -> throw VortexInvalidValueException("User PhoneNumber Required", AttrMissingDetails("PhoneNumber", "Attribute Missing"))
            entity.password.length < 8 -> throw VortexInvalidValueException("User Password Must Be 8 At Minimum", AttrMissingDetails("Password", "Validation"))
            else -> {
                entity.accountStatus = "NOT_ACTIVATED"
                getRepository().save(entity)
            }
        }
        return getEntityById(entity.id)
    }

    fun sendMessage(phoneNumber: String, pinCode: String) {
        Thread(Runnable {
            try {
                MessageSenderConfiguration().sendSms(
                        "Destiny Services",
                        "Welcome To Destiny Services The Account Code is : $pinCode",
                        phoneNumber
                )
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }).start()
    }

    override fun getEntityById(id: Long): Profile {
        try {
            return getRepository().findById(id).get()
        } catch (ex: NoSuchElementException) {
            ex.printStackTrace()
            throw VortexNotFoundException(ex.message, EmptyErrorDetails(id, ex.message))
        }
    }

    fun validateCode(body: PinCodeBody, phoneNumberService: PhoneNumberService): PinCodeResponse {
        val result = phoneNumberService.varifyPinCode(body.pinCode, body.userId)
        if (result.status.equals("ACTIVATED")) {
            val user = getRepository().findById(body.userId).get()
            user.accountStatus = "ACTIVATED"
            getRepository().save(user)
        }
        return result
    }

    fun createNewAccount(content: Profile): AuthResponse {
        val result = create(content)
        return AuthResponse(
                "Bearer ${JwtTokenUtil().generateToken(result)}",
                ProfileResponse(
                        id = result.id,
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

    fun createPinCode(id: Long, phoneNumberService: PhoneNumberService): String {
        val code = getGeneratedCode()
        phoneNumberService.create(PhoneNumber(
                id,
                code,
                "NOT_ACTIVATED"
        ))
        return code
    }

    private fun getGeneratedCode(): String {
        var code = ""
        for (i in 0..3) {
            code += Random().nextInt(9)
        }
        return code
    }

    fun login(body: LoginBody): AuthResponse {
        val result = getRepository().findByEmailAndPassword(body.email, body.password).get()
        return AuthResponse(
                "Bearer ${JwtTokenUtil().generateToken(result)}",
                ProfileResponse(
                        id = result.id,
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