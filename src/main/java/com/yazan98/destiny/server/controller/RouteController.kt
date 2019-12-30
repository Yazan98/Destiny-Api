package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.main.Route
import com.yazan98.destiny.server.data.repository.RouteRepository
import com.yazan98.destiny.server.service.RouteService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.ArrayList

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:41 PM
 */

@RestController
@RequestMapping("/v1/routs")
class RouteController @Autowired constructor(service: RouteService) :
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
    @RequestMapping(method = [RequestMethod.GET], value = ["/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        return super.getAll()
    }

}