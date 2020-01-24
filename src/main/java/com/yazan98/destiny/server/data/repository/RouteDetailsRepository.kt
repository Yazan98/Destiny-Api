package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.main.route.RouteDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RouteDetailsRepository : JpaRepository<RouteDetails, Long> {

    fun findByRouteId(routeId: Long): RouteDetails

}