package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.main.route.RouteStory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RouteStoryRepository : JpaRepository<RouteStory, Long> {

    fun findAllByRouteId(routeId: Long): List<RouteStory>

}