package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.service.BaseService
import io.vortex.spring.boot.base.models.database.VortexBaseEntity
import io.vortex.spring.boot.base.response.VortexResponse
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.ResponseEntity

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:46 AM
 */
interface BaseControllerImpl<E : VortexBaseEntity, ID, R : MongoRepository<E, ID>, S : BaseService<ID, E, R>> {

    fun save(content: E?): ResponseEntity<VortexResponse>

    fun update(content: E?): ResponseEntity<VortexResponse>

    fun deleteById(id: ID?): ResponseEntity<VortexResponse>

    fun deleteAll(): ResponseEntity<VortexResponse>

    fun getById(id: ID?): ResponseEntity<VortexResponse>

    fun getAll(): ResponseEntity<VortexResponse>

    fun getService(): S

}