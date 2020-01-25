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
                        "Full Meat",
                        "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                        10.20
                ),
                Offer(
                        "Full Meat",
                        "https://images.unsplash.com/photo-1476224203421-9ac39bcb3327?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                        10.20
                ), Offer(
                "Fresh Meat",
                "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                20.0
        )
        )
    }

}
