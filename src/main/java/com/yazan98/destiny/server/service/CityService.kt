package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.City
import com.yazan98.destiny.server.data.repository.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:26 PM
 */

@Service
@Transactional
open class CityService @Autowired constructor(private val repo: CityRepository) : BaseService<Long , City , CityRepository>() {

    override fun create(entity: City): City {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): CityRepository {
        return repo
    }

    override fun update(entity: City): City {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}