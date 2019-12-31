package com.yazan98.destiny.server.error

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 12/31/2019
 * Time : 3:08 PM
 */
data class EmptyLoginDetails(
        val email: String,
        val password: String,
        val reason: String
): ErrorDetails