package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.main.fav.Fav
import com.yazan98.destiny.server.data.repository.FavRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:04 PM
 */

@Service
@Transactional
open class FavService @Autowired constructor(private val repo: FavRepository) : BaseService<Long , Fav , FavRepository>() {
    override fun create(entity: Fav): Fav {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): FavRepository {
        return repo
    }

    override fun update(entity: Fav): Fav {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}