package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.main.Place
import com.yazan98.destiny.server.data.repository.PlaceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:55 PM
 */

@Service
@Transactional
open class PlaceService @Autowired constructor(private val repo: PlaceRepository) : BaseService<Long , Place , PlaceRepository>() {

    override fun create(entity: Place): Place {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): PlaceRepository {
        return repo
    }

    override fun update(entity: Place): Place {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}