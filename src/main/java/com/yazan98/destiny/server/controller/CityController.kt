package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.City
import com.yazan98.destiny.server.data.repository.CityRepository
import com.yazan98.destiny.server.response.CityResponse
import com.yazan98.destiny.server.service.CityService
import com.yazan98.destiny.server.service.PlaceService
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:27 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/cities")
class CityController @Autowired constructor(service: CityService, private val placesService: PlaceService) : VortexMysqlController<City, Long, CityRepository, CityService>(service) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = [""])
    fun getCityInformationByCityId(@RequestParam("cityId") cityId: Long): ResponseEntity<VortexResponse> {
        val places = placesService.getAllByCityId(cityId)
        return ResponseEntity.status(HttpStatus.OK.value()).body(VortexSuccessResponse(
                code = HttpStatus.OK.value(),
                message = "Data Found",
                data = CityResponse(getService().getEntityById(cityId), places , places.size)
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        return super.getAll()
    }

}
