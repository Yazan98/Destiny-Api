package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.place.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, Long> {
}