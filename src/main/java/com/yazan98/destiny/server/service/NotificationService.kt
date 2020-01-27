package com.yazan98.destiny.server.service

import com.google.firebase.messaging.*
import com.yazan98.destiny.server.body.OfferBody
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 1:32 PM
 */

@Service
@Transactional
open class NotificationService {

    fun createNewOffer(body: OfferBody): String {
        val message = Message.builder()
                .putData("title", body.title)
                .putData("body", body.body)
                .setTopic("app_offers")
                .setAndroidConfig(getAndroidConfiguration(body.title, body.body))
                .setNotification(Notification(body.title, body.body))
                .build()
        val response = FirebaseMessaging.getInstance().send(message)
        println("Successfully sent message: $response")
        return response
    }

    private fun getAndroidConfiguration(title: String, body: String): AndroidConfig? {
        return AndroidConfig.builder()
                .setNotification(AndroidNotification.builder().setBody(body).setTitle(title).setPriority(AndroidNotification.Priority.HIGH).build())
                .setPriority(AndroidConfig.Priority.HIGH)
                .build()
    }

}