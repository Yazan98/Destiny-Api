package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.main.Collection
import com.yazan98.destiny.server.data.repository.CollectionRepository
import com.yazan98.destiny.server.service.CollectionService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:44 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/collections")
class CollectionController @Autowired constructor(service: CollectionService) :
        VortexMysqlController<Collection, Long, CollectionRepository, CollectionService>(service) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = [""])
    fun getPopularRouts(@RequestParam("promoted") type: Boolean): ResponseEntity<VortexResponse> {
        val result: ArrayList<Collection> = if (type) {
            getService().getPromotedCollections()
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

}
