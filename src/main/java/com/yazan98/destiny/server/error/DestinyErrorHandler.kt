package com.yazan98.destiny.server.error

import io.vortex.spring.boot.base.errors.ErrorDetails
import io.vortex.spring.boot.base.errors.VortexExceptionHandler
import io.vortex.spring.boot.base.response.VortexError
import io.vortex.spring.boot.base.response.VortexErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:18 AM
 */

@ControllerAdvice
open class DestinyErrorHandler : VortexExceptionHandler() {

    @ExceptionHandler(PinCodeInvalidValue::class)
    fun handlePromoCode(request: HttpServletRequest, exception: PinCodeInvalidValue): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.BAD_REQUEST.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Invalid Code",
                                exception.getDetails(),
                                exception.stackTrace
                        )
                ),
                HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoElementException(request: HttpServletRequest, exception: NoSuchElementException): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.NOT_FOUND.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Invalid Code",
                                NoSuchException("There is No Result From Database"),
                                exception.stackTrace
                        )
                ),
                HttpStatus.NOT_FOUND
        )
    }

    data class NoSuchException(
            val reason: String
    ) : ErrorDetails

}
