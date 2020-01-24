package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.body.AddressUser
import com.yazan98.destiny.server.data.entity.place.Address
import com.yazan98.destiny.server.data.repository.AddressRepository
import com.yazan98.destiny.server.service.AddressService
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.details.BodyErrorDetails
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/address")
class ProfileAddressController @Autowired constructor(service: AddressService) :
        VortexMysqlController<Address, Long, AddressRepository, AddressService>(service) {

//    @ResponseBody
//    @RequestMapping(method = [RequestMethod.POST], value = [""])
//    fun saveAddressByUserId(@Valid @RequestBody content: AddressUser?): ResponseEntity<VortexResponse> {
//        if (content == null) {
//            throw VortexInvalidValueException("Body Required", BodyErrorDetails(
//                    "Body Not Attached",
//                    "Create Request"
//            ))
//        } else {
//            val result = getService().createByUserId(content)
//            return ResponseEntity.status(HttpStatus.CREATED).body(VortexSuccessResponse(
//                    code = HttpStatus.CREATED.value(),
//                    message = "Data Saved",
//                    data = result
//            ))
//        }
//    }

}
