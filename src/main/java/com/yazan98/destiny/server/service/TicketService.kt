package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.data.entity.Ticket
import com.yazan98.destiny.server.data.repository.TicketRepository
import io.vortex.spring.boot.base.errors.EmptyErrorDetails
import io.vortex.spring.boot.base.errors.VortexNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 11:03 PM
 */

@Service
@Transactional
open class TicketService @Autowired constructor(private val repo: TicketRepository) : BaseService<Long , Ticket , TicketRepository>() {

    override fun create(entity: Ticket): Ticket {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    fun getTicketsByUserId(id: Long): ArrayList<Ticket> {
        try {
            return if (checkRepoStatus(getRepository())) {
                getRepository().findAllByUserId(id) as ArrayList<Ticket>
            } else {
                throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(null, "No Data Available For This Section"))
            }
        } catch (ex: EmptyResultDataAccessException) {
            throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(null, ex.message))
        }
    }

    override fun getRepository(): TicketRepository {
        return repo
    }

    override fun update(entity: Ticket): Ticket {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}