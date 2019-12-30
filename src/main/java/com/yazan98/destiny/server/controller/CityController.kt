package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.City
import com.yazan98.destiny.server.data.repository.CityRepository
import com.yazan98.destiny.server.service.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:27 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/cities")
class CityController @Autowired constructor(service: CityService) :
        VortexMysqlController<City, Long, CityRepository, CityService>(service) {

}