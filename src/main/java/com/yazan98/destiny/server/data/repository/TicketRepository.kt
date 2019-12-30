package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 11:02 PM
 */

@Repository
interface TicketRepository : JpaRepository<Ticket , Long> {

    fun findAllByUserId(userId: Long): List<Ticket>

}