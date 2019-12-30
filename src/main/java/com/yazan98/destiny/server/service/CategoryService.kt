package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.category.Category
import com.yazan98.destiny.server.data.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:21 PM
 */

@Service
@Transactional
open class CategoryService @Autowired constructor(private val repo: CategoryRepository) : BaseService<Long , Category , CategoryRepository>() {

    override fun getRepository(): CategoryRepository {
        return repo
    }

    override fun update(entity: Category): Category {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(entity: Category): Category {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

}