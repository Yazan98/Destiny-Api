package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.Food
import com.yazan98.destiny.server.data.repository.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class FoodService @Autowired constructor(private val repo: FoodRepository) : BaseService<Long, Food, FoodRepository>() {
    override fun create(entity: Food): Food {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): FoodRepository {
        return repo
    }

    override fun update(entity: Food): Food {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
