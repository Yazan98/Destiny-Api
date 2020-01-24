package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.Food
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : JpaRepository<Food, Long> {
}