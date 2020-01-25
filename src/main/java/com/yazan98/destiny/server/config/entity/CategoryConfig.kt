package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.controller.CategoryController
import com.yazan98.destiny.server.controller.FoodController
import com.yazan98.destiny.server.data.entity.category.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class CategoryConfig @Autowired constructor(placesController: CategoryController) {

    init {
        getAllCategories().forEach {
            placesController.save(it)
        }
    }

    private fun getAllCategories(): List<Category> {
        return arrayListOf(
                Category(
                        "Steak",
                        "https://images.unsplash.com/photo-1542365887-1149961dccc7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
                ),
                Category(
                        "Shrimp",
                        "https://images.unsplash.com/photo-1565511224465-3948cfdd6d2a?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
                ),
                Category(
                        "Ham",
                        "https://images.unsplash.com/photo-1558888565-86add11fa452?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80"
                ),
                Category(
                        "Fish",
                        "https://images.unsplash.com/photo-1534948216015-843149f72be3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
                ),
                Category(
                        "Sushi",
                        "https://images.unsplash.com/photo-1553621042-f6e147245754?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=925&q=80"
                )
        )
    }

}