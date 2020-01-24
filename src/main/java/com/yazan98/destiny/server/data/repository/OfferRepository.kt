package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.Offer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OfferRepository : JpaRepository<Offer, Long> {
}