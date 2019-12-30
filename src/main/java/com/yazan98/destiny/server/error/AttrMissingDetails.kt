package com.yazan98.destiny.server.error

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:38 AM
 */
data class AttrMissingDetails(
        val name: String,
        val reason: String
): ErrorDetails