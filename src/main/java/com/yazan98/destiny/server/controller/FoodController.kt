package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.Food
import com.yazan98.destiny.server.data.repository.FoodRepository
import com.yazan98.destiny.server.service.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/foods")
class FoodController @Autowired constructor(repository: FoodService) : VortexMysqlController<Food, Long, FoodRepository, FoodService>(repository) {

}
