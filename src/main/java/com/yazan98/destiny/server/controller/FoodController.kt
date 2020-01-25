package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.Food
import com.yazan98.destiny.server.data.repository.FoodRepository
import com.yazan98.destiny.server.service.FoodService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/recipes")
class FoodController @Autowired constructor(repository: FoodService) : VortexMysqlController<Food, Long, FoodRepository, FoodService>(repository) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = [""])
    fun getAllPopularRecipes(@RequestParam(value = "popular") popular: Boolean): ResponseEntity<VortexResponse> {
        val result = getService().getAllRecipesPopular(popular)
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/category/{id}"])
    fun getRecipesByCategoryId(@PathVariable(value = "id") popular: Long): ResponseEntity<VortexResponse> {
        val result = getService().getByCategoryId(popular)
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        return super.getAll()
    }

}
