package com.yazan98.destiny.server.service

import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.AndroidConfig
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.yazan98.destiny.server.body.OfferBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 1:32 PM
 */

@Service
@Transactional
open class NotificationService @Autowired constructor(private val firebase: FirebaseApp) {

    fun createNewOffer(body: OfferBody): String {
        val message = Message.builder()
                .putData("title", body.title)
                .putData("body", body.body)
                .setAndroidConfig(getAndroidConfiguration())
                .setTopic("app_offers")
                .build()
        val response = FirebaseMessaging.getInstance().send(message)
        println("Successfully sent message: $response")
        return response
    }

    private fun getAndroidConfiguration(): AndroidConfig? {
        return AndroidConfig.builder()
                .setRestrictedPackageName("com.destiny.services")
                .setPriority(AndroidConfig.Priority.HIGH)
                .build()
    }

}