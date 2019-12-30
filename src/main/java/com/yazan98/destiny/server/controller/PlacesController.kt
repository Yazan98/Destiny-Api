package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.main.Place
import com.yazan98.destiny.server.data.repository.PlaceRepository
import com.yazan98.destiny.server.service.PlaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:57 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/places")
class PlacesController @Autowired constructor(service: PlaceService) :
        VortexMysqlController<Place, Long, PlaceRepository, PlaceService>(service) {
}
