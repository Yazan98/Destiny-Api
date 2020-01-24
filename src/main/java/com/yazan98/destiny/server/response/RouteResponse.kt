package com.yazan98.destiny.server.response

import com.yazan98.destiny.server.data.entity.main.route.Route
import com.yazan98.destiny.server.data.entity.main.route.RouteDetails
import com.yazan98.destiny.server.data.entity.main.route.RouteStory

data class RouteResponse(
        val route: Route,
        val details: RouteDetails,
        val stories: List<RouteStory>
)