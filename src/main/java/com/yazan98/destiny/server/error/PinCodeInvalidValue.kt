package com.yazan98.destiny.server.error

import io.vortex.spring.boot.base.errors.ErrorDetails
import io.vortex.spring.boot.base.errors.VortexException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:06 PM
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
open class PinCodeInvalidValue(override val message: String?, details: PinCodeInvalid) : VortexException(message , details) {
    init {
        logException(this)
    }
}

data class PinCodeInvalid(
        val code: String,
        val status: String
): ErrorDetails