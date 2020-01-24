package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.main.route.RouteComments
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RouteCommentsRepository : JpaRepository<RouteComments, Long> {

    fun findAllByRouteId(routeId: Long): List<RouteComments>

}
