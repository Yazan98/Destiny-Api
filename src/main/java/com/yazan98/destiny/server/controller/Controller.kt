package com.yazan98.destiny.server.controller

import com.yazan98.destiny.server.service.BaseService
import io.vortex.spring.boot.base.models.database.VortexBaseEntity
import io.vortex.spring.boot.base.models.database.VortexMysqlEntity
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.service.VortexMysqlService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:18 PM
 */

interface Controller<E: VortexBaseEntity , ID , R: JpaRepository<E , ID>> {

    fun save(content: E?): ResponseEntity<VortexResponse>

    fun update(content: E?): ResponseEntity<VortexResponse>

    fun deleteById(id: ID?): ResponseEntity<VortexResponse>

    fun deleteAll(): ResponseEntity<VortexResponse>

    fun getById(id: ID?): ResponseEntity<VortexResponse>

    fun getAll(): ResponseEntity<VortexResponse>

    fun getService(): BaseService<ID , E , R>

}