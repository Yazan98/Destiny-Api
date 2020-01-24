package com.yazan98.destiny.server.response

import com.yazan98.destiny.server.data.entity.City
import com.yazan98.destiny.server.data.entity.place.Place

/**
 * Created By : Yazan Tarifi
 * Date : 12/31/2019
 * Time : 2:14 PM
 */
data class CityResponse(
        val city: City,
        val places: ArrayList<Place>,
        val size: Int
)
