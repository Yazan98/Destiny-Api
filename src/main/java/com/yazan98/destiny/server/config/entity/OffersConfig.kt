package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.controller.OffersController
import com.yazan98.destiny.server.data.entity.Offer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class OffersConfig @Autowired constructor(offersController: OffersController) {

    init {
        getAllOffers().forEach {
            offersController.save(it)
        }
    }

    private fun getAllOffers(): List<Offer> {
        return arrayListOf(
                Offer(
                        "Fresh Meat",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project%20(5).png?alt=media&token=128d052d-ce33-4777-bf6c-91ce64a102c2",
                        20.0
                ),
                Offer(
                        "Full Meat",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project%20(6).png?alt=media&token=178da89e-d4a3-4605-acbe-f3eb9c89c093",
                        10.20
                )
        )
    }

}
