package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.data.entity.Ticket
import com.yazan98.destiny.server.data.repository.TicketRepository
import com.yazan98.destiny.server.service.PlaceService
import com.yazan98.destiny.server.service.TicketService
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.details.BodyErrorDetails
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 11:04 PM
 */

@CrossOrigin
@RestController
@RequestMapping("/v1/tickets")
class TicketsController @Autowired constructor(service: TicketService, private val placesService: PlaceService)
    : VortexMysqlController<Ticket, Long, TicketRepository, TicketService>(service) {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = [""])
    fun getTicketsByUserId(@RequestParam("userId") userId: Long): ResponseEntity<VortexResponse> {
        val result = getService().getTicketsByUserId(userId)
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

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/info"])
    override fun getById(@RequestParam("id") id: Long?): ResponseEntity<VortexResponse> {
        return super.getById(id)
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], value = [""])
    override fun save(@Valid @RequestBody content: Ticket?): ResponseEntity<VortexResponse> {
        if (content == null) {
            throw VortexInvalidValueException("Body Required", BodyErrorDetails(
                    "Body Not Attached",
                    "Create Request"
            ))
        } else {
            val result = getService().createNewTicket(content, placesService)
            return ResponseEntity.status(HttpStatus.CREATED).body(VortexSuccessResponse(
                    code = HttpStatus.CREATED.value(),
                    message = "Data Saved",
                    data = result
            ))
        }
    }

}
