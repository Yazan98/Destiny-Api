package com.yazan98.destiny.server.response

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 2:35 PM
 */
data class AuthResponse(
        var token: String? = null,
        val user: ProfileResponse? = null
)