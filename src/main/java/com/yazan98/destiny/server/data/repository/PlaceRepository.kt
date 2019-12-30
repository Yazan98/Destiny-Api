package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.main.Place
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:54 PM
 */

@Repository
interface PlaceRepository : JpaRepository<Place , Long> {
}