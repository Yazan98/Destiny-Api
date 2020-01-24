package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.Offer
import com.yazan98.destiny.server.data.repository.OfferRepository
import io.vortex.spring.boot.base.service.VortexMysqlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class OffersService @Autowired constructor(private val repo: OfferRepository) : BaseService<Long, Offer, OfferRepository>() {

    override fun create(entity: Offer): Offer {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): OfferRepository {
       return repo
    }

    override fun update(entity: Offer): Offer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
