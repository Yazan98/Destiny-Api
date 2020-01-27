package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.order.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {

    fun findAllByProfileId(profileId: Long): List<Order>

}