package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.main.Collection
import com.yazan98.destiny.server.data.repository.CollectionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:41 PM
 */

@Service
@Transactional
open class CollectionService @Autowired constructor(private val repo: CollectionRepository)
    : BaseService<Long, Collection, CollectionRepository>() {
    override fun create(entity: Collection): Collection {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): CollectionRepository {
        return repo
    }

    fun getPromotedCollections(): ArrayList<Collection> {
        val result = ArrayList<Collection>()
        getAllEntities().forEach {
            if (it.popular.equals("true")) {
                result.add(it)
            }
        }
        return result
    }

    override fun update(entity: Collection): Collection {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}