package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.body.RouteDetailsBody
import com.yazan98.destiny.server.data.entity.main.route.Route
import com.yazan98.destiny.server.data.entity.main.route.RouteComments
import com.yazan98.destiny.server.data.repository.RouteDetailsRepository
import com.yazan98.destiny.server.data.repository.RouteRepository
import com.yazan98.destiny.server.data.repository.RouteStoryRepository
import com.yazan98.destiny.server.service.RouteService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:41 PM
 */

@RestController
@RequestMapping("/v1/routs")
class RouteController @Autowired constructor(service: RouteService, private val detailsRepo: RouteDetailsRepository,
                                             private val storyRepo: RouteStoryRepository) :
        VortexMysqlController<Route, Long, RouteRepository, RouteService>(service) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = [""])
    fun getPopularRouts(@RequestParam("type") type: String): ResponseEntity<VortexResponse> {
        val result: ArrayList<Route> = if (type.equals("popular")) {
            getService().getPopularRouts()
        } else {
            getService().getAllEntities()
        }
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], value = ["/details"])
    fun addRouteDetailsRequest(@RequestBody body: RouteDetailsBody): ResponseEntity<VortexResponse> {
        val result = getService().addRouteDetails(body, detailsRepo, storyRepo)
        return ResponseEntity.status(HttpStatus.CREATED).body(VortexSuccessResponse(
                code = HttpStatus.CREATED.value(),
                message = "Data Saved",
                data = result
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], value = ["/details/comment"])
    fun addRouteComment(@RequestBody body: RouteComments): ResponseEntity<VortexResponse> {
        val result = addRouteComment(body)
        return ResponseEntity.status(HttpStatus.CREATED).body(VortexSuccessResponse(
                code = HttpStatus.CREATED.value(),
                message = "Data Saved",
                data = result
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/{id}/comments"])
    fun getRouteComments(@PathVariable("id") id: Long): ResponseEntity<VortexResponse> {
        val result = getService().getCommentsById(id)
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/{id}/details"])
    fun getDetailsByRouteId(@PathVariable("id") id: Long): ResponseEntity<VortexResponse> {
        println("Request : The Id is : ${id}")
        return ResponseEntity.status(HttpStatus.OK).body(VortexSuccessResponse(
                HttpStatus.OK.value(),
                "Data Found",
                "Success",
                getService().getRouteDetailsByRouteId(id, detailsRepo, storyRepo)
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        return super.getAll()
    }

}
