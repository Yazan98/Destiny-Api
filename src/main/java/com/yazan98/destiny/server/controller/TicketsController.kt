package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.Ticket
import com.yazan98.destiny.server.data.repository.TicketRepository
import com.yazan98.destiny.server.service.TicketService
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 11:04 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/tickets")
class TicketsController @Autowired constructor(service: TicketService)
    : VortexMysqlController<Ticket , Long , TicketRepository , TicketService>(service) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/{userId}"])
    fun getTicketsByUserId(@PathVariable("userId") userId: Long): ResponseEntity<VortexResponse> {
        val result = getService().getTicketsByUserId(userId)
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

}
