package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.order.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemsRepository : JpaRepository<OrderItem, Long> {

    fun findAllByOrderId(orderId: Long): List<OrderItem>

}