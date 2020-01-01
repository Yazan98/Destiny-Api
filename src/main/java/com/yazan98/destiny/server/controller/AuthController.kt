package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.body.LoginBody
import com.yazan98.destiny.server.body.PinCodeBody
import com.yazan98.destiny.server.body.UpdatePasswordBody
import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.ProfileRepository
import com.yazan98.destiny.server.service.PhoneNumberService
import com.yazan98.destiny.server.service.ProfileService
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:41 AM
 */

@CrossOrigin
@RestController
@RequestMapping("v1/accounts")
class AuthController @Autowired constructor(service: ProfileService, private val phoneNumberService: PhoneNumberService)
    : VortexMysqlController<Profile, Long, ProfileRepository, ProfileService>(service) {

    @ResponseBody
    @RequestMapping(value = ["/register"], method = [RequestMethod.POST])
    override fun save(@Valid @RequestBody content: Profile?): ResponseEntity<VortexResponse> {
        val profile = content?.let { getService().createNewAccount(it) }
        profile?.user?.id?.let {
            val result = getService().createPinCode(it, phoneNumberService)
            getService().sendMessage(profile.user.phoneNumber , result)
        }

        return ResponseEntity.ok(VortexSuccessResponse(
                HttpStatus.CREATED.value(),
                "Account Created",
                "Success",
                profile
        ))
    }

    @ResponseBody
    @GetMapping(value = ["/", "/all"], path = ["/", "/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        return super.getAll()
    }

    @ResponseBody
    @RequestMapping(value = ["/validate"], method = [RequestMethod.POST])
    fun validatePinCode(@Valid @RequestBody body: PinCodeBody): ResponseEntity<VortexResponse> {
        val response = getService().validateCode(body, phoneNumberService)
        return ResponseEntity.ok(VortexSuccessResponse(
                HttpStatus.OK.value(),
                "Pin Code Validation",
                "Success",
                response
        ))
    }

    @ResponseBody
    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun login(@Valid @RequestBody body: LoginBody): ResponseEntity<VortexResponse> {
        val response = getService().login(body)
        return ResponseEntity.ok(VortexSuccessResponse(
                HttpStatus.OK.value(),
                "Data Found",
                "Success",
                response
        ))
    }

    @ResponseBody
    @RequestMapping(value = ["/password"], method = [RequestMethod.PUT])
    fun updatePassword(@Valid @RequestBody body: UpdatePasswordBody): ResponseEntity<VortexResponse> {
        val response = getService().updatePassword(body)
        return ResponseEntity.ok(VortexSuccessResponse(
                HttpStatus.OK.value(),
                "Password Updated",
                "Success",
                response
        ))
    }

}
