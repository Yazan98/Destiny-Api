package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : JpaRepository<Recipe, Long> {

    fun findAllByIsPopular(popular: Boolean): List<Recipe>

    fun findAllByCategoryId(id: Long): List<Recipe>

}