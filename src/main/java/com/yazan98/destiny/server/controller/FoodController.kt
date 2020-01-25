package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.body.RecipeCommentBody
import com.yazan98.destiny.server.data.entity.Recipe
import com.yazan98.destiny.server.data.repository.FoodRepository
import com.yazan98.destiny.server.data.repository.RecipeCommentsRepository
import com.yazan98.destiny.server.service.FoodService
import com.yazan98.destiny.server.service.ProfileService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/recipes")
class FoodController @Autowired constructor(
        repository: FoodService,
        private val recipeCommentsRepository: RecipeCommentsRepository,
        private val profileService: ProfileService
) : VortexMysqlController<Recipe, Long, FoodRepository, FoodService>(repository) {

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
    @RequestMapping(method = [RequestMethod.GET], value = ["/{id}/comments"])
    fun getAllCommentsBRecipeId(@PathVariable(value = "id") id: Long): ResponseEntity<VortexResponse> {
        val result = recipeCommentsRepository.findAllByRecipeId(id)
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], value = ["/comment"])
    fun saveComment(@Valid @RequestBody content: RecipeCommentBody): ResponseEntity<VortexResponse> {
        val result = getService().saveCommentByProfileName(content, profileService, recipeCommentsRepository)
        return ResponseEntity.status(HttpStatus.CREATED).body(VortexSuccessResponse(
                code = HttpStatus.CREATED.value(),
                message = "Data Saved",
                data = result
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        return super.getAll()
    }

}
