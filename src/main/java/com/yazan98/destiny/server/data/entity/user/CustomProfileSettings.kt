package com.yazan98.destiny.server.data.entity.user

/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 1:54 PM
 */
data class CustomProfileSettings(
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    var id: Long? = 0,
    val status: String,
    val image: String,
    val pinCode: String
)