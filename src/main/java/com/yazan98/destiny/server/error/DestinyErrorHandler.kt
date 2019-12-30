package com.yazan98.destiny.server.error

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
open class DestinyErrorHandler {

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

}
