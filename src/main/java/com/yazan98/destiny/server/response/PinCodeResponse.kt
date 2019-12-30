package com.yazan98.destiny.server.response

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:09 PM
 */
data class PinCodeResponse(
        val userId: Long,
        val status: String,
        val pinCode: String
)