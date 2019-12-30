package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.category.Category
import com.yazan98.destiny.server.data.repository.CategoryRepository
import com.yazan98.destiny.server.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:23 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/categories")
class CategoryController @Autowired constructor(service: CategoryService) :
        VortexMysqlController<Category, Long, CategoryRepository, CategoryService>(service) {
}
