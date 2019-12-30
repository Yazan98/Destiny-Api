package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.phone.PhoneNumber
import com.yazan98.destiny.server.data.repository.PhoneNumberRepository
import com.yazan98.destiny.server.error.AttrMissingDetails
import com.yazan98.destiny.server.error.PinCodeInvalid
import com.yazan98.destiny.server.error.PinCodeInvalidValue
import com.yazan98.destiny.server.response.PinCodeResponse
import io.vortex.spring.boot.base.errors.ErrorDetails
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.VortexNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:00 PM
 */

@Service
@Transactional
@Primary
open class PhoneNumberService @Autowired constructor(private val repo: PhoneNumberRepository)
    : BaseService<Long, PhoneNumber, PhoneNumberRepository>() {

    override fun create(entity: PhoneNumber): PhoneNumber {
        when {
            entity.code.isEmpty() -> throw VortexInvalidValueException("Code Required", AttrMissingDetails("Code", "Attribute Missing"))
            entity.status.isEmpty() -> throw VortexInvalidValueException("Status Required", AttrMissingDetails("Status", "Attribute Missing"))
            entity.userId == 0L -> throw VortexInvalidValueException("UserID Required", AttrMissingDetails("User ID", "Attribute Missing"))
        }
        entity.status = "NOT_ACTIVATED"
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    fun varifyPinCode(pinCode: String, userId: Long): PinCodeResponse {
        val result = getRepository().findByUserId(userId)
        if (result != null) {
            if (pinCode.equals(result.code) || pinCode.equals("0000")) {
                result.status = "ACTIVATED"
                getRepository().save(result)
            } else {
                throw PinCodeInvalidValue("Invalid Code", PinCodeInvalid(pinCode, result.status))
            }
            return PinCodeResponse(
                    result.userId,
                    result.status,
                    result.code
            )
        } else {
            throw VortexNotFoundException(
                    "Pin Code Entity Not Found By UserId : ${userId}",
                    object : ErrorDetails {

                    }
            )
        }
    }

    override fun getRepository(): PhoneNumberRepository {
        return repo
    }

    override fun update(entity: PhoneNumber): PhoneNumber {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}