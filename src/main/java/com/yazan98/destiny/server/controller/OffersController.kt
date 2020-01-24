package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.Offer
import com.yazan98.destiny.server.data.repository.OfferRepository
import com.yazan98.destiny.server.service.OffersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/offers")
open class OffersController @Autowired constructor(service: OffersService) :
        VortexMysqlController<Offer, Long, OfferRepository, OffersService>(service) {

}
