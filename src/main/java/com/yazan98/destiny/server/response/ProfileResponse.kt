package com.yazan98.destiny.server.response

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 2:41 PM
 */

data class ProfileResponse(
        var id: Long = 0,
        var username: String = "",
        var email: String = "",
        var phoneNumber: String = "",
        var image: String = "",
        var enabled: Boolean = false,
        var accountStatus: String = "",
        var location: ProfileLocationResponse
)


data class ProfileLocationResponse(
        val latitude: Double,
        val longitude: Double
)