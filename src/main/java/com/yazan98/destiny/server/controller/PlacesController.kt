package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.main.Place
import com.yazan98.destiny.server.data.repository.PlaceRepository
import com.yazan98.destiny.server.service.PlaceService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = [""])
    fun getPlacesByCategoryId(@RequestParam("categoryId") id: Long): ResponseEntity<VortexResponse> {
        val result = getService().getAllByCategoryId(id)
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
