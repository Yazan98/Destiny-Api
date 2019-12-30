package com.yazan98.destiny.server.error

import io.vortex.spring.boot.base.errors.VortexExceptionHandler
import org.springframework.web.bind.annotation.ControllerAdvice

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:18 AM
 */
@ControllerAdvice
open class ExceptionHandler : VortexExceptionHandler()