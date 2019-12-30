package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.main.fav.Fav
import com.yazan98.destiny.server.data.repository.FavRepository
import com.yazan98.destiny.server.service.FavService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:05 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/fav")
class FavController @Autowired constructor(service: FavService) :
        VortexMysqlController<Fav , Long , FavRepository , FavService>(service) {

}
