package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.body.RouteDetailsBody
import com.yazan98.destiny.server.data.entity.main.route.Route
import com.yazan98.destiny.server.data.entity.main.route.RouteComments
import com.yazan98.destiny.server.data.entity.main.route.RouteDetails
import com.yazan98.destiny.server.data.entity.main.route.RouteStory
import com.yazan98.destiny.server.data.repository.RouteCommentsRepository
import com.yazan98.destiny.server.data.repository.RouteDetailsRepository
import com.yazan98.destiny.server.data.repository.RouteRepository
import com.yazan98.destiny.server.data.repository.RouteStoryRepository
import com.yazan98.destiny.server.error.AttrMissingDetails
import com.yazan98.destiny.server.response.RouteResponse
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:37 PM
 */

@Service
@Transactional
open class RouteService @Autowired constructor(
        private val repo: RouteRepository,
        private val commentsRepo: RouteCommentsRepository
) : BaseService<Long, Route, RouteRepository>() {

    override fun create(entity: Route): Route {
        return when {
            entity.image.isEmpty() -> throw VortexInvalidValueException("Route Image Required",
                    AttrMissingDetails("Image",
                            "Attribute Missing"))

            entity.name.isEmpty() -> throw VortexInvalidValueException("Route Name Required",
                    AttrMissingDetails("Name",
                            "Attribute Missing"))

            entity.places == 0L -> throw VortexInvalidValueException("Route Places Required",
                    AttrMissingDetails("Places",
                            "Attribute Missing"))

            else -> {
                getRepository().save(entity)
                getEntityById(entity.id)
            }
        }
    }

    fun getPopularRouts(): ArrayList<Route> {
        val entities = getAllEntities()
        val result = ArrayList<Route>()
        entities.forEach {
            if (it.type.equals("POPULAR")) {
                result.add(it)
            }
        }

        return result
    }

    override fun getRepository(): RouteRepository {
        return repo
    }

    fun getRouteDetailsByRouteId(routeId: Long, detailsRepo: RouteDetailsRepository, storyRepo: RouteStoryRepository): RouteResponse {
        val route = getEntityById(routeId)
        val stories: List<RouteStory> = storyRepo.findAllByRouteId(routeId)
        val details = detailsRepo.findByRouteId(routeId)
        return RouteResponse(route, details, stories)
    }

    fun addRouteDetails(details: RouteDetailsBody, detailsRepo: RouteDetailsRepository, storyRepo: RouteStoryRepository): RouteResponse {
        details.stories.forEach { storyRepo.save(it) }
        detailsRepo.save(details.details)
        val route = getEntityById(details.details.routeId)
        val stories = storyRepo.findAllByRouteId(details.details.routeId)
        val details = detailsRepo.findByRouteId(details.details.routeId)
        return RouteResponse(route, details, stories)
    }

    fun getCommentsById(id: Long): List<RouteComments> {
        return commentsRepo.findAllByRouteId(id)
    }

    override fun update(entity: Route): Route {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}