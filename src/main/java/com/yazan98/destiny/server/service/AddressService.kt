package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.body.AddressUser
import com.yazan98.destiny.server.data.entity.place.Address
import com.yazan98.destiny.server.data.entity.place.PlaceDetails
import com.yazan98.destiny.server.data.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class AddressService @Autowired constructor(private val repo: AddressRepository) : BaseService<Long, Address, AddressRepository>() {

    override fun create(entity: Address): Address {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    fun createByUserId(content: AddressUser): Address {
        val result = repo.save(Address(
                content.name,
                content.id,
                PlaceDetails(
                        content.latitude,
                        content.longitude
                )
        ))
        return result
    }

    override fun getRepository(): AddressRepository {
        return repo
    }

    override fun update(entity: Address): Address {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
