package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.main.Collection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:41 PM
 */

@Repository
interface CollectionRepository : JpaRepository<Collection , Long> {
}
