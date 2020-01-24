package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.controller.CityController
import com.yazan98.destiny.server.data.entity.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class CityConfig @Autowired constructor(cityController: CityController) {

    init {
        getAllCities().forEach {
            cityController.save(it)
        }
    }

    private fun getAllCities(): List<City> {
        return arrayListOf(
                City(
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2Fflag-round-250.png?alt=media&token=b3949e27-692f-4bba-968e-a2b7dc658c14",
                        "Jordan"
                )
        )
    }

}
