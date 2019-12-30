package com.yazan98.destiny.server.service

import io.vortex.spring.boot.base.errors.EmptyErrorDetails
import io.vortex.spring.boot.base.errors.VortexInternalServerException
import io.vortex.spring.boot.base.errors.VortexNotFoundException
import io.vortex.spring.boot.base.models.database.VortexBaseEntity
import io.vortex.spring.boot.base.service.VortexBaseService
import io.vortex.spring.boot.base.service.VortexMongoServiceImpl
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:31 AM
 */

@Service
abstract class BaseService<ID, Entity : VortexBaseEntity, Repo : MongoRepository<Entity, ID>>
    : VortexBaseService<ID, Entity, Repo> {

    @Throws(VortexNotFoundException::class)
    override fun getAllEntities(): ArrayList<Entity> {
        try {
            return if (checkRepoStatus(getRepository())) {
                getRepository().findAll() as ArrayList<Entity>
            } else {
                throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(null, "No Data Available For This Section"))
            }
        } catch (ex: Exception) {
            throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(null, ex.message))
        }

    }

    @Throws(VortexNotFoundException::class)
    override fun getEntityById(id: ID): Entity {
        try {
            return if (checkRepoStatus(getRepository())) {
                getRepository().findById(id).get()
            } else {
                throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(id, "No Data Available For This Section"))
            }
        } catch (ex: Exception) {
            throw VortexNotFoundException(ex.message, EmptyErrorDetails(id, ex.message))
        }
    }

    override fun checkRepoStatus(repo: Repo): Boolean = getRepository().count() > 0

    override fun deleteAllEntities() {
        getRepository().deleteAll()
    }

    @Throws(VortexNotFoundException::class)
    override fun deleteEntityById(id: ID): Boolean {
        return if (checkRepoStatus(getRepository())) {
            getRepository().deleteById(id)
            try {
                getEntityById(id)
                throw VortexInternalServerException("Data Not Deleted", VortexInternalServerException.DataNotDeletedDetails(
                        id,
                        "Data Not Deleted For This ID ... Still in Database"
                ))
            } catch (ex: Exception) {
                true
            }
        } else {
            throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(id, "No Data To Delete At This Section"))
        }
    }

}