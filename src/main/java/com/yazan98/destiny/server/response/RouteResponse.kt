package com.yazan98.destiny.server.response

import com.yazan98.destiny.server.data.entity.main.route.Route
import com.yazan98.destiny.server.data.entity.main.route.RouteDetails
import com.yazan98.destiny.server.data.entity.main.route.RouteStory

data class RouteResponse(
        val route: Route,
        val details: RouteDetails,
        val stories: List<RouteStory>
)

data class RouteDetailsResponse(
        val id: Long,
        val name: String,
        val image: String,
        val routeId: Long,
        val shortDescription: String,
        val description: String,
        val rating: Float,
        val icon: String,
        val background: String,
        val location: String,
        val stories: List<RouteStory>
)
