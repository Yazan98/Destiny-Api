package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:26 PM
 */

@Repository
interface CityRepository : JpaRepository<City , Long> {
}