package com.yazan98.destiny.server.error

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 12:57 PM
 */
data class TokenErrorDetails(
        val message: String
): ErrorDetails