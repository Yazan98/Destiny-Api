package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.route.Route
import com.yazan98.destiny.server.data.repository.RouteRepository
import com.yazan98.destiny.server.error.AttrMissingDetails
import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:37 PM
 */

@Service
@Transactional
open class RouteService @Autowired constructor(private val repo: RouteRepository) : BaseService<Long , Route , RouteRepository>() {

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

            else -> getEntityById(entity.id)
        }
    }

    fun getPopularRouts(): ArrayList<Route> {
        val entities = getAllEntities()
        val result = ArrayList<Route>()
        entities.forEach {
            if(it.type.equals("POPULAR")) {
                result.add(it)
            }
        }

        return result
    }

    override fun getRepository(): RouteRepository {
        return repo
    }

    override fun update(entity: Route): Route {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}