package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.body.OfferBody
import com.yazan98.destiny.server.service.NotificationService
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.details.BodyErrorDetails
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 1:28 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/notifications")
class NotificationsController @Autowired constructor(private val service: NotificationService) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], value = ["/offer"])
    fun createNewOffer(@RequestBody @Valid body: OfferBody?): ResponseEntity<VortexResponse> {
        if (body == null) {
            throw VortexInvalidValueException("Body Required", BodyErrorDetails(
                    "Body Not Attached",
                    "Create New Offer (Notifications Section)"
            ))
        } else {
            val response = service.createNewOffer(body)
            return ResponseEntity.ok(VortexSuccessResponse(
                    HttpStatus.OK.value(),
                    "Notification Sent To Offers Successfully",
                    "Success",
                    NotificationResponse("Topic : app_offers", response)
            ))
        }
    }

    data class NotificationResponse(
            val details: String,
            val response: String
    )
}